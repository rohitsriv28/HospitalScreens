package com.example.hospital.presentation

data class MoreInfoUiStateThird(
    var operationGrade: String = "",
    var anaesthetist: String = "",
    var anaesthesia: String = "",
    var surgeon: String = "",
    var asstDoc: String = "",
    var asstNurse: String = "",
    var createdDate: String = "",
    var createdBy: String = "",
    var updatedBy: String = "",
    var updatedDate: String = "",
    var status: String = "",

    var isInvalidOperationGrade: Boolean = false,
    var isInvalidAnaesthetist: Boolean = false,
    var isInvalidAnaesthesia: Boolean = false,
    var isInvalidSurgeon: Boolean = false,
    var isInvalidAsstDoc: Boolean = false,
    var isInvalidAsstNurse: Boolean = false,
    var isInvalidCreatedDate: Boolean = false,
    var isInvalidCreatedBy: Boolean = false,
    var isInvalidUpdatedBy: Boolean = false,
    var isInvalidUpdatedDate: Boolean = false,
    var isInvalidStatus: Boolean = false,
)
