package com.hedger.flavore.model.service.impl

import com.google.firebase.auth.FirebaseAuth
import com.hedger.flavore.model.User
import com.hedger.flavore.model.service.AccountService
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AccountServiceImpl @Inject constructor(private val auth: FirebaseAuth): AccountService {
    override val currentUserId: String
        get() = auth.currentUser?.uid.orEmpty()

    override val hasUser: Boolean
        get() = auth.currentUser != null

    override val currentUser: Flow<User>
        get() = callbackFlow {
            val listener =
                FirebaseAuth.AuthStateListener { auth ->
                    this.trySend(auth.currentUser?.let { User(it.uid,it.isAnonymous) }?:User())
                }
            auth.addAuthStateListener { listener }
            awaitClose{auth.removeAuthStateListener { listener }}
        }

    //adding await makes code wait for authentication,
    //so the process after auth wont continue before auth complete
    override suspend fun authenticate(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password).await()
    }


    override suspend fun sendRecoveryEmail(email: String) {
        auth.sendPasswordResetEmail(email).await()
    }

    override suspend fun createAnonymousAccount() {
        auth.signInAnonymously().await()
    }

    override suspend fun linkAccount(email: String, password: String) {
        TODO("Not yet implemented")
    }

    // !! means telling compiler the value 100% not null
    override suspend fun deleteAccount() {
        auth.currentUser!!.delete().await()
    }

    override suspend fun signOut() {
        if(auth.currentUser!!.isAnonymous){
            auth.currentUser!!.delete()
        }
        auth.signOut()
    }
}



