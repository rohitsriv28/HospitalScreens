package com.example.hospital.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.hospital.ui.components.isValidAddress
import com.example.hospital.ui.components.isValidEmail
import com.example.hospital.ui.components.isValidEmpId
import com.example.hospital.ui.components.isValidName
import com.example.hospital.ui.components.isValidPassword
import com.example.hospital.ui.components.isValidPhone
import com.example.hospital.ui.components.isValidUserId

class RegistrationViewModel : ViewModel() {
    var registrationUiState by mutableStateOf(RegUiState())

    fun updateName(value: String) {
        registrationUiState = registrationUiState.copy(
            name = value,
            isInvalidName = registrationUiState.name.isNotEmpty() && !isValidName(
                registrationUiState.name
            )
        )
    }

    fun updateEmpId(value: String) {
        registrationUiState = registrationUiState.copy(
            empId = value,
            isInvalidEmpId = registrationUiState.empId.isNotEmpty() && !isValidEmpId(
                registrationUiState.empId
            )
        )
    }

    fun updateUserId(value: String) {
        registrationUiState = registrationUiState.copy(
            userId = value,
            isInvalidUserId = registrationUiState.userId.isNotEmpty() && !isValidUserId(
                registrationUiState.userId
            )
        )
    }

    fun updatePassword(value: String) {
        registrationUiState = registrationUiState.copy(
            password = value,
            isInvalidPassword = registrationUiState.empId.isNotEmpty() && !isValidPassword(
                registrationUiState.password
            )
        )
    }

    fun updatePhone(value: String) {
        registrationUiState = registrationUiState.copy(
            phone = value,
            isInvalidPhone = registrationUiState.phone.isNotEmpty() && !isValidPhone(
                registrationUiState.phone
            )
        )
    }

    fun updateAddress(value: String) {
        registrationUiState = registrationUiState.copy(
            address = value,
            isInvalidAddress = registrationUiState.address.isNotEmpty() && !isValidAddress(
                registrationUiState.address
            )
        )
    }

    fun updateEmail(value: String) {
        registrationUiState = registrationUiState.copy(
            email = value,
            isInvalidEmail = registrationUiState.email.isNotEmpty() && !isValidEmail(
                registrationUiState.email
            )
        )
    }
}


