package com.example.hospital.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.hospital.ui.components.isValidAddress
import com.example.hospital.ui.components.isValidBedNo
import com.example.hospital.ui.components.isValidDiagnosis
import com.example.hospital.ui.components.isValidLP
import com.example.hospital.ui.components.isValidName
import com.example.hospital.ui.components.isValidSerial

class PatientEntryViewModel : ViewModel() {
    var patientEntryUiState by mutableStateOf(PatientEntryUiState())

    fun updateSno(value: String) {
        patientEntryUiState = patientEntryUiState.copy(
            sNo = value,
            isInvalidSerial = patientEntryUiState.sNo.isNotEmpty() && !isValidSerial(
                patientEntryUiState.sNo
            )
        )
    }

    fun updateLpNo(value: String) {
        patientEntryUiState = patientEntryUiState.copy(
            lpNo = value,
            isInvalidLpNo = patientEntryUiState.lpNo.isNotEmpty() && !isValidLP(
                patientEntryUiState.lpNo
            )
        )
    }

    fun updateName(value: String) {
        patientEntryUiState = patientEntryUiState.copy(
            name = value,
            isInvalidName = patientEntryUiState.name.isNotEmpty() && !isValidName(
                patientEntryUiState.name
            )
        )
    }

    fun updateAddress(value: String) {
        patientEntryUiState = patientEntryUiState.copy(
            address = value,
            isInvalidAddress = patientEntryUiState.address.isNotEmpty() && !isValidAddress(
                patientEntryUiState.address
            )
        )
    }

    fun updateDiagnosis(value: String) {
        patientEntryUiState = patientEntryUiState.copy(
            diagnosis = value,
            isInvalidDiagnosis = patientEntryUiState.diagnosis.isNotEmpty() && !isValidDiagnosis(
                patientEntryUiState.diagnosis
            )
        )
    }

    fun updateBedNo(value: String) {
        patientEntryUiState = patientEntryUiState.copy(
            bedNo = value,
            isInvalidBedNo = patientEntryUiState.bedNo.isNotEmpty() && !isValidBedNo(
                patientEntryUiState.bedNo
            )
        )
    }

}
