package com.hedger.flavore.ui.screens.eatwhat

import androidx.compose.runtime.mutableStateOf
import com.hedger.flavore.model.service.LogService
import com.hedger.flavore.ui.screens.FlavoReViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class EatWhatViewModel @Inject constructor(
logService: LogService
): FlavoReViewModel(logService){


    //thinking can i use val, and delete private set
    var uiState = mutableStateOf(EatWhatState())
        private set


    fun onDistanceChange(input: String) {
        uiState.value = uiState.value.copy(distance = input)
    }

    fun onAddressChange(input: String) {
        uiState.value = uiState.value.copy(address = input)
    }
}