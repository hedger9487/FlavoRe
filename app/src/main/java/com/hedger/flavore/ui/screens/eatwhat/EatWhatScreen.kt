package com.hedger.flavore.ui.screens.eatwhat

import androidx.compose.foundation.layout.Column
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.hedger.flavore.R
import com.hedger.flavore.common.composable.BasicField

@Composable
@ExperimentalMaterialApi
fun EatWhatScreen(
    openAndPopUp: (String, String) -> Unit,
    modifier: Modifier = Modifier,
    // eatwhatviewmodel must inherit flavoreviewmodel
viewModel: EatWhatViewModel = hiltViewModel()
){
    val uiState by viewModel.uiState


    Column {
        BasicField(text = R.string.distance, value = uiState.distance , onNewValue = viewModel::onDistanceChange)
        BasicField(text = R.string.address, value = uiState.address, onNewValue = viewModel::onAddressChange)
    }




}