package com.example.hospital.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.hospital.ui.components.isValidLicense
import com.example.hospital.ui.components.isValidLogo
import com.example.hospital.ui.components.isValidName
import com.example.hospital.ui.components.isValidRegNo
import com.example.hospital.ui.components.isValidWebsite

class CompRegViewModel : ViewModel() {
    var compRegUiState by mutableStateOf(CompRegUiState())

    fun updateName(value: String) {
        compRegUiState = compRegUiState.copy(
            companyName = value,
            isInvalidName = compRegUiState.companyName.isNotEmpty() && !isValidName(
                compRegUiState.companyName)
        )
    }

    fun updateLogo(value: String) {
        compRegUiState = compRegUiState.copy(
            companyLogo = value,
            isInvalidLogo = compRegUiState.companyLogo.isNotEmpty() && !isValidLogo(
                compRegUiState.companyLogo)
        )
    }

    fun updateWebsiteLink(value: String) {
        compRegUiState = compRegUiState.copy(
            websiteLink = value,
            isInvalidWebsiteLink = compRegUiState.websiteLink.isNotEmpty() && !isValidWebsite(
                compRegUiState.websiteLink)
        )
    }

    fun updateRegNo(value: String) {
        compRegUiState = compRegUiState.copy(
            regNo = value,
            isInvalidRegNo = compRegUiState.regNo.isNotEmpty() && !isValidRegNo(
                compRegUiState.regNo)
        )
    }

    fun updateLicenseKey(value: String) {
        compRegUiState = compRegUiState.copy(
            licenseKey = value,
            isInvalidLicense = compRegUiState.licenseKey.isNotEmpty() && !isValidLicense(
                compRegUiState.licenseKey)
        )
    }
}
