package com.hedger.flavore.ui.screens.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.runtime.getValue
import com.hedger.flavore.R
import com.hedger.flavore.common.composable.BasicButton
import com.hedger.flavore.common.composable.BasicToolBar
import com.hedger.flavore.common.composable.EmailField
import com.hedger.flavore.common.composable.PasswordField
import com.hedger.flavore.common.ext.basicButton
import com.hedger.flavore.common.ext.fieldModifier

@Composable
fun LoginScreen(
    openAndPopUp: (String, String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = hiltViewModel()
){
    // import androidx.compose.runtime.getValue
    // no need remember, because viewModel use mutableStateOf, and here use delegate
    val uiState by viewModel.uiState

    Scaffold(
        topBar = { BasicToolBar(title = R.string.login_details)},
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            EmailField(uiState.email, {viewModel.onEmailChange(it)}, Modifier.fieldModifier())
            PasswordField(uiState.password, viewModel::onPasswordChange, Modifier.fieldModifier())

            BasicButton(R.string.sign_in, Modifier.basicButton()) { viewModel.onSignInClick(openAndPopUp) }

//            BasicTextButton(AppText.forgot_password, Modifier.textButton()) {
//                viewModel.onForgotPasswordClick()
            }

        }
}
