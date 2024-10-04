package com.example.hospital.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.hospital.ui.components.isValidAge
import com.example.hospital.ui.components.isValidAmount
import com.example.hospital.ui.components.isValidDiagnosis
import com.example.hospital.ui.components.isValidName
import com.example.hospital.ui.components.isValidStaff

class EhsViewModel: ViewModel() {
    var ehsUiState by mutableStateOf(EhsUiState())

    fun updateName(value: String) {
        ehsUiState = ehsUiState.copy(
            name = value,
            isInvalidName = ehsUiState.name.isNotEmpty() && !isValidName(
                ehsUiState.name
            )
        )
    }

    fun updateAge(value: String) {
        ehsUiState = ehsUiState.copy(
            age = value,
            isInvalidAge = ehsUiState.age.isNotEmpty() && !isValidAge(
                ehsUiState.age
            )
        )
    }

    fun updateDiagnosis(value: String) {
        ehsUiState = ehsUiState.copy(
            diagnosis = value,
            isInvalidDiagnosis = ehsUiState.diagnosis.isNotEmpty() && !isValidDiagnosis(
                ehsUiState.diagnosis
            )
        )
    }

    fun updateStaff(value: String) {
        ehsUiState = ehsUiState.copy(
            staff = value,
            isInvalidStaff = ehsUiState.staff.isNotEmpty() && !isValidStaff(
                ehsUiState.staff
            )
        )
    }

    fun updateAmount(value: String) {
        ehsUiState = ehsUiState.copy(
            amount = value,
            isInvalidAmount = ehsUiState.amount.isNotEmpty() && !isValidAmount(
                ehsUiState.amount
            )
        )
    }
}
