package com.hedger.flavore.ui.screens.login

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hedger.flavore.LOGIN_SCREEN
import com.hedger.flavore.R
import com.hedger.flavore.SETTINGS_SCREEN
import com.hedger.flavore.common.ext.isValidEmail
import com.hedger.flavore.common.snackbar.SnackbarManager
import com.hedger.flavore.model.service.AccountService
import com.hedger.flavore.model.service.LogService
import com.hedger.flavore.ui.screens.FlavoReViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val accountService: AccountService,
    logService: LogService
): FlavoReViewModel(logService) {

    //using mutableStateOf in viewmodel to manage states
    //the screen composable can directly use by to delegate,
    // no need to use remember
    var uiState = mutableStateOf(LoginUiState())
        private set

    private val email
        get() = uiState.value.email
    private val password
        get() = uiState.value.password

    fun onEmailChange(input: String) {
        uiState.value = uiState.value.copy(email = input)
    }

    fun onPasswordChange(input: String){
        uiState.value = uiState.value.copy(password = input)
    }


    fun onSignInClick(openAndPopUp: (String,String) -> Unit){

        if(!email.isValidEmail()){
            // TODO:  log messages
        }


        if(!password.isEmpty()){
            // todo: log messages and modify the function to check password
        }


        //not sure to add await or not, sample code has no await,
        //maybe need to await the result, then depends on the result to navigate
        launchCatching {
            accountService.sendRecoveryEmail(email)
            SnackbarManager.showMessage(R.string.recovery_email_sent)
        }
    }




}