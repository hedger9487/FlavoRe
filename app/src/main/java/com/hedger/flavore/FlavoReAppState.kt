package com.hedger.flavore

import androidx.navigation.NavController
import androidx.navigation.NavHostController

class FlavoReAppState(
    val navController: NavHostController
) {
    fun popUp(){
        navController.popBackStack()
    }

    fun navigate(route: String) {
        //launchSingleTop making exactly one same page in the backstack
        navController.navigate(route){ launchSingleTop = true }
    }


    //pop up the backstack until the destination
    // scenario: if a user logs out, and use back button to go previous page
    //u have to pop the authorized pages first, otherwise the logged out user
    // could have go back to the logged in pages
    fun navigateAndPopUp(route: String, popUp: String) {
        navController.navigate(route) {
            launchSingleTop = true
            popUpTo(popUp) { inclusive = true }
        }
    }

}