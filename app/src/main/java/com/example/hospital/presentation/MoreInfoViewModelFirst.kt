package com.example.hospital.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.hospital.ui.components.isValidAmount
import com.example.hospital.ui.components.isValidCreatedBy
import com.example.hospital.ui.components.isValidDoctor
import com.example.hospital.ui.components.isValidMinor
import com.example.hospital.ui.components.isValidMinorCa
import com.example.hospital.ui.components.isValidStaff
import com.example.hospital.ui.components.isValidStatus
import com.example.hospital.ui.components.isValidUpdatedBy
import com.example.hospital.ui.components.isValidUpdatedDate

class MoreInfoViewModelFirst: ViewModel() {
    var moreInfoUiStateFirst by mutableStateOf(MoreInfoUiStateFirst())

    fun updateMinor(value: String) {
        moreInfoUiStateFirst = moreInfoUiStateFirst.copy(
            minor = value,
            isInvalidMinor = moreInfoUiStateFirst.minor.isNotEmpty() && !isValidMinor(
                moreInfoUiStateFirst.minor
            )
        )
    }

    fun updateMinorCa(value: String) {
        moreInfoUiStateFirst = moreInfoUiStateFirst.copy(
            minorCa = value,
            isInvalidMinorCa = moreInfoUiStateFirst.minorCa.isNotEmpty() && !isValidMinorCa(
                moreInfoUiStateFirst.minorCa
            )
        )
    }
    fun updateDoctor(value: String) {
        moreInfoUiStateFirst = moreInfoUiStateFirst.copy(
            doctor = value,
            isInvalidDoctor = moreInfoUiStateFirst.doctor.isNotEmpty() && !isValidDoctor(
                moreInfoUiStateFirst.doctor
            )
        )
    }
    fun updateStaff(value: String) {
        moreInfoUiStateFirst = moreInfoUiStateFirst.copy(
            staff = value,
            isInvalidStaff = moreInfoUiStateFirst.staff.isNotEmpty() && !isValidStaff(
                moreInfoUiStateFirst.staff
            )
        )
    }
    fun updateAmount(value: String) {
        moreInfoUiStateFirst = moreInfoUiStateFirst.copy(
            amount = value,
            isInvalidAmount = moreInfoUiStateFirst.amount.isNotEmpty() && !isValidAmount(
                moreInfoUiStateFirst.amount
            )
        )
    }
    fun updateCreatedBy(value: String) {
        moreInfoUiStateFirst = moreInfoUiStateFirst.copy(
            createdBy = value,
            isInvalidCreatedBy = moreInfoUiStateFirst.createdBy.isNotEmpty() && !isValidCreatedBy(
                moreInfoUiStateFirst.createdBy
            )
        )
    }
    fun updateUpdatedBy(value: String) {
        moreInfoUiStateFirst = moreInfoUiStateFirst.copy(
            updatedBy = value,
            isInvalidUpdatedBy = moreInfoUiStateFirst.updatedBy.isNotEmpty() && !isValidUpdatedBy(
                moreInfoUiStateFirst.updatedBy
            )
        )
    }
    fun updateUpdatedDate(value: String) {
        moreInfoUiStateFirst = moreInfoUiStateFirst.copy(
            updatedDate = value,
            isInvalidUpdatedDate = moreInfoUiStateFirst.minorCa.isNotEmpty() && !isValidUpdatedDate(
                moreInfoUiStateFirst.minorCa
            )
        )
    }
    fun updateStatus(value: String) {
        moreInfoUiStateFirst = moreInfoUiStateFirst.copy(
            status = value,
            isInvalidStatus = moreInfoUiStateFirst.status.isNotEmpty() && !isValidStatus(
                moreInfoUiStateFirst.minorCa
            )
        )
    }
}
