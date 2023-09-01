package com.hedger.flavore.ui.screens.splash

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.hedger.flavore.R
import com.hedger.flavore.common.composable.BasicButton
import com.hedger.flavore.common.ext.basicButton
import kotlinx.coroutines.delay

private const val SPLASH_TIMEOUT = 1000L
@Composable
fun SplashScreen(
    openAndPopUp: (String, String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: SplashViewModel = hiltViewModel()
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment =Alignment.CenterHorizontally
    ) {
        if (viewModel.error.value) {
            Text(text = stringResource(R.string.generic_error))

            BasicButton(R.string.try_again, Modifier.basicButton()) { viewModel.onAppStart(openAndPopUp) }
        } else {
            CircularProgressIndicator(color = MaterialTheme.colors.onBackground)
        }
    }

    // not sure the usage for now
    // seems launching a coroutine for compose
    LaunchedEffect(true) {
        delay(SPLASH_TIMEOUT)
        viewModel.onAppStart(openAndPopUp)
    }

}