package com.hedger.flavore

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.ExperimentalMaterialApi
import dagger.hilt.android.AndroidEntryPoint

//telling hilt where the instance is needed to inject
@AndroidEntryPoint
@ExperimentalMaterialApi
//AppCompatActivity for material design and fancy feature
//otherwise lightweight use activity
class FlavoReActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent { FlavoReApp() }
    }
}