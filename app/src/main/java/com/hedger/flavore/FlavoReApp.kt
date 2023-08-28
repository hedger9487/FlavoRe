package com.hedger.flavore

import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.hedger.flavore.theme.FlavoReTheme

@Composable
@ExperimentalMaterialApi
fun FlavoReApp(

) {
    FlavoReTheme {
        Surface(color = MaterialTheme.colors.background){

            Scaffold(
                topBar = { TODO() }
            ) { innerPadding ->
                NavHost(navController = navController, graph = ,modifier = Modifier.padding(innerPadding) )
                
            }



        }

    }
    
}