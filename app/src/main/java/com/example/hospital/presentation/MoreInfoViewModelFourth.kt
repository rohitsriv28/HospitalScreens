package com.example.hospital.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.hospital.ui.components.isValidEmail

class MoreInfoViewModelFourth: ViewModel(){
    var moreInfoUiStateFourth by mutableStateOf(MoreInfoUiStateFourth())

    fun updateEmail(value: String) {
        moreInfoUiStateFourth = moreInfoUiStateFourth.copy(
            email = value,
            isInvalidEmail = moreInfoUiStateFourth.email.isNotEmpty() && !isValidEmail(
                moreInfoUiStateFourth.email
            )
        )
    }
}
