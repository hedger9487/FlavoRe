package com.hedger.flavore

import android.content.res.Resources
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hedger.flavore.theme.FlavoReTheme
import com.hedger.flavore.ui.screens.login.LoginScreen
import com.hedger.flavore.ui.screens.splash.SplashScreen
import kotlinx.coroutines.CoroutineScope

@Composable
@ExperimentalMaterialApi
fun FlavoReApp() {
    FlavoReTheme {
        Surface(color = MaterialTheme.colors.background){
            val appState = rememberAppState()
            Scaffold(
                topBar = { TODO() }
            ) { innerPadding ->
                NavHost(
                    navController = appState.navController,
                    startDestination = SPLASH_SCREEN,
                    modifier = Modifier.padding(innerPadding)
                ){
                    FlavoReGraph(appState)
                }
                
            }



        }

    }
    
}


@Composable
// easier to manage app states
fun rememberAppState(
    navController: NavHostController = rememberNavController(),
    resources: Resources = resources(),
    coroutineScope: CoroutineScope = rememberCoroutineScope()
    ) =
    remember(navController, resources, coroutineScope){
        FlavoReAppState(navController, resources, coroutineScope)
}


@Composable
@ReadOnlyComposable
// not sure usage,
// similar to R.string or R. ...
fun resources(): Resources {
    LocalConfiguration.current
    return LocalContext.current.resources
}

@ExperimentalMaterialApi
fun NavGraphBuilder.FlavoReGraph(appState: FlavoReAppState) {
    composable(SPLASH_SCREEN) {
        SplashScreen(openAndPopUp = { route, popUp -> appState.navigateAndPopUp(route, popUp) })
    }
    composable(LOGIN_SCREEN) {
        LoginScreen(openAndPopUp = { route, popUp -> appState.navigateAndPopUp(route, popUp) })
    }
}