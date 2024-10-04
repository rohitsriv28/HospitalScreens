package com.example.hospital.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.hospital.ui.components.isValidAge
import com.example.hospital.ui.components.isValidAnaesthetist
import com.example.hospital.ui.components.isValidAsstDoctor
import com.example.hospital.ui.components.isValidAsstNurse
import com.example.hospital.ui.components.isValidDiagnosis
import com.example.hospital.ui.components.isValidName
import com.example.hospital.ui.components.isValidRemark

class OtViewModel : ViewModel() {
    var otUiState by mutableStateOf(OtUiState())

    fun updateName(value: String) {
        otUiState = otUiState.copy(
            name = value,
            isInvalidName = otUiState.name.isNotEmpty() && !isValidName(
                otUiState.name
            )
        )
    }

    fun updateAge(value: String) {
        otUiState = otUiState.copy(
            age = value,
            isInvalidAge = otUiState.age.isNotEmpty() && !isValidAge(
                otUiState.age
            )
        )
    }

    fun updateDiagnosis(value: String) {
        otUiState = otUiState.copy(
            diagnosis = value,
            isInvalidDiagnosis = otUiState.diagnosis.isNotEmpty() && !isValidDiagnosis(
                otUiState.diagnosis
            )
        )
    }

    fun updateAnaesthetist(value: String) {
        otUiState = otUiState.copy(
            anaesthetist = value,
            isInvalidAnaesthetist = otUiState.anaesthetist.isNotEmpty() && !isValidAnaesthetist(
                otUiState.anaesthetist
            )
        )
    }

    fun updateAsstDoctor(value: String) {
        otUiState = otUiState.copy(
            asstDoctor = value,
            isInvalidAsstDoctor = otUiState.asstDoctor.isNotEmpty() && !isValidAsstDoctor(
                otUiState.asstDoctor
            )
        )
    }

    fun updateAsstNurse(value: String) {
        otUiState = otUiState.copy(
            asstNurse = value,
            isInvalidAsstNurse = otUiState.asstNurse.isNotEmpty() && !isValidAsstNurse(
                otUiState.asstNurse
            )
        )
    }

    fun updateRemark(value: String) {
        otUiState = otUiState.copy(
            remark = value,
            isInvalidRemark = otUiState.remark.isNotEmpty() && !isValidRemark(
                otUiState.remark
            )
        )
    }

}














