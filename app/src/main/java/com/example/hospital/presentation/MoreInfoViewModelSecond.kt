package com.example.hospital.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.hospital.ui.components.isValidArrivalDate
import com.example.hospital.ui.components.isValidBedNo
import com.example.hospital.ui.components.isValidDepartingDate
import com.example.hospital.ui.components.isValidDiagnosis
import com.example.hospital.ui.components.isValidRemark
import com.example.hospital.ui.components.isValidStatus
import com.example.hospital.ui.components.isValidTime

class MoreInfoViewModelSecond: ViewModel() {
    var moreInfoUiStateSecond by mutableStateOf(MoreInfoUiStateSecond())

    fun updateDiagnosis(value: String) {
        moreInfoUiStateSecond = moreInfoUiStateSecond.copy(
            diagnosis = value,
            isInvalidDiagnosis = moreInfoUiStateSecond.diagnosis.isNotEmpty() && !isValidDiagnosis(
                moreInfoUiStateSecond.diagnosis
            )
        )
    }

    fun updateBedNo(value: String) {
        moreInfoUiStateSecond = moreInfoUiStateSecond.copy(
            bedNo = value,
            isInvalidBedNo = moreInfoUiStateSecond.bedNo.isNotEmpty() && !isValidBedNo(
                moreInfoUiStateSecond.bedNo
            )
        )
    }fun updateTime(value: String) {
        moreInfoUiStateSecond = moreInfoUiStateSecond.copy(
            time = value,
            isInvalidTime = moreInfoUiStateSecond.time.isNotEmpty() && !isValidTime(
                moreInfoUiStateSecond.time
            )
        )
    }
    fun updateArrivalDate(value: String) {
        moreInfoUiStateSecond = moreInfoUiStateSecond.copy(
            arrivingDate = value,
            isInvalidArrivalDate = moreInfoUiStateSecond.arrivingDate.isNotEmpty() && !isValidArrivalDate(
                moreInfoUiStateSecond.arrivingDate
            )
        )
    }
    fun updateDepartureDate(value: String) {
        moreInfoUiStateSecond = moreInfoUiStateSecond.copy(
            departingDate = value,
            isInvalidDepartingDate = moreInfoUiStateSecond.departingDate.isNotEmpty() && !isValidDepartingDate(
                moreInfoUiStateSecond.departingDate
            )
        )
    }
    fun updateRemark(value: String) {
        moreInfoUiStateSecond = moreInfoUiStateSecond.copy(
            remark = value,
            isInvalidRemark = moreInfoUiStateSecond.remark.isNotEmpty() && !isValidRemark(
                moreInfoUiStateSecond.remark
            )
        )
    }
    fun updateStatus(value: String) {
        moreInfoUiStateSecond = moreInfoUiStateSecond.copy(
            status = value,
            isInvalidStatus = moreInfoUiStateSecond.status.isNotEmpty() && !isValidStatus(
                moreInfoUiStateSecond.status
            )
        )
    }
}
