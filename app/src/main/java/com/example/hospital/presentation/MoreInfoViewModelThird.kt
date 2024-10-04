package com.example.hospital.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.hospital.ui.components.isValidAnaesthesia
import com.example.hospital.ui.components.isValidAnaesthetist
import com.example.hospital.ui.components.isValidAsstDoctor
import com.example.hospital.ui.components.isValidAsstNurse
import com.example.hospital.ui.components.isValidCreatedBy
import com.example.hospital.ui.components.isValidCreatedDate
import com.example.hospital.ui.components.isValidOperationGrade
import com.example.hospital.ui.components.isValidStatus
import com.example.hospital.ui.components.isValidSurgeon
import com.example.hospital.ui.components.isValidUpdatedBy
import com.example.hospital.ui.components.isValidUpdatedDate

class MoreInfoViewModelThird: ViewModel() {
    var moreInfoUiStateThird by mutableStateOf(MoreInfoUiStateThird())

    fun updateOperationGrade(value: String) {
        moreInfoUiStateThird = moreInfoUiStateThird.copy(
            operationGrade = value,
            isInvalidOperationGrade = moreInfoUiStateThird.operationGrade.isNotEmpty() && !isValidOperationGrade(
                moreInfoUiStateThird.operationGrade
            )
        )
    }
    fun updateAnaesthetist(value: String) {
        moreInfoUiStateThird = moreInfoUiStateThird.copy(
            anaesthetist = value,
            isInvalidAnaesthetist = moreInfoUiStateThird.anaesthetist.isNotEmpty() && !isValidAnaesthetist(
                moreInfoUiStateThird.anaesthetist
            )
        )
    }
    fun updateAnaesthesia(value: String) {
        moreInfoUiStateThird = moreInfoUiStateThird.copy(
            anaesthesia = value,
            isInvalidAnaesthesia = moreInfoUiStateThird.anaesthesia.isNotEmpty() && !isValidAnaesthesia(
                moreInfoUiStateThird.anaesthesia
            )
        )
    }
    fun updateSurgeon(value: String) {
        moreInfoUiStateThird = moreInfoUiStateThird.copy(
            surgeon = value,
            isInvalidSurgeon = moreInfoUiStateThird.surgeon.isNotEmpty() && !isValidSurgeon(
                moreInfoUiStateThird.surgeon
            )
        )
    }
    fun updateAsstDoc(value: String) {
        moreInfoUiStateThird = moreInfoUiStateThird.copy(
            asstDoc = value,
            isInvalidAsstDoc = moreInfoUiStateThird.asstDoc.isNotEmpty() && !isValidAsstDoctor(
                moreInfoUiStateThird.asstDoc
            )
        )
    }
    fun updateAsstNurse(value: String) {
        moreInfoUiStateThird = moreInfoUiStateThird.copy(
            asstNurse = value,
            isInvalidAsstNurse = moreInfoUiStateThird.asstNurse.isNotEmpty() && !isValidAsstNurse(
                moreInfoUiStateThird.asstNurse
            )
        )
    }
    fun updateCreatedDate(value: String) {
        moreInfoUiStateThird = moreInfoUiStateThird.copy(
            createdDate = value,
            isInvalidCreatedDate = moreInfoUiStateThird.createdDate.isNotEmpty() && !isValidCreatedDate(
                moreInfoUiStateThird.createdDate
            )
        )
    }
    fun updateCreatedBy(value: String) {
        moreInfoUiStateThird = moreInfoUiStateThird.copy(
            createdBy = value,
            isInvalidCreatedBy = moreInfoUiStateThird.createdBy.isNotEmpty() && !isValidCreatedBy(
                moreInfoUiStateThird.createdBy
            )
        )
    }
    fun updateUpdatedBy(value: String) {
        moreInfoUiStateThird = moreInfoUiStateThird.copy(
            updatedBy = value,
            isInvalidUpdatedBy = moreInfoUiStateThird.updatedBy.isNotEmpty() && !isValidUpdatedBy(
                moreInfoUiStateThird.updatedBy
            )
        )
    }
    fun updateUpdatedDate(value: String) {
        moreInfoUiStateThird = moreInfoUiStateThird.copy(
            updatedDate = value,
            isInvalidUpdatedDate = moreInfoUiStateThird.updatedDate.isNotEmpty() && !isValidUpdatedDate(
                moreInfoUiStateThird.updatedDate
            )
        )
    }
    fun updateStatus(value: String) {
        moreInfoUiStateThird = moreInfoUiStateThird.copy(
            status = value,
            isInvalidStatus = moreInfoUiStateThird.status.isNotEmpty() && !isValidStatus(
                moreInfoUiStateThird.status
            )
        )
    }
}
