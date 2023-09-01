package com.hedger.flavore.ui.screens.splash

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuthException
import com.hedger.flavore.EATWHAT_SCREEN
import com.hedger.flavore.SPLASH_SCREEN
import com.hedger.flavore.model.service.AccountService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SplashViewModel @Inject constructor(
    //the hilt will deal with impl,
    // since we have service module binding the interface and impl
    private val accountService: AccountService,
) : ViewModel() {

    val error = mutableStateOf(false)


    fun onAppStart(openAndPopUp: (String, String) -> Unit) {
        error.value = false
        if (accountService.hasUser) openAndPopUp(EATWHAT_SCREEN, SPLASH_SCREEN)
        else createAnonymousAccount(openAndPopUp)
    }

    private fun createAnonymousAccount(openAndPopUp: (String, String) -> Unit){
        // viewModelScope is supervisorJob
        // if child coroutine throw ex, parent wont get cancel
        viewModelScope.launch(
            block = {
                try {
                    accountService.createAnonymousAccount()
                } catch (ex: FirebaseAuthException) {
                    error.value = true
                }
                openAndPopUp(EATWHAT_SCREEN, SPLASH_SCREEN)
            }
        )

    }




}