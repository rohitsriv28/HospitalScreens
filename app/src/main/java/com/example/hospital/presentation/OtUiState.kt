package com.example.hospital.presentation

data class OtUiState(
    var name: String = "",
    var age: String = "",
    var diagnosis: String = "",
    var anaesthetist: String = "",
    var asstDoctor: String = "",
    var asstNurse: String = "",
    var remark: String = "",

    var isInvalidName: Boolean = false,
    var isInvalidAge: Boolean = false,
    var isInvalidDiagnosis: Boolean = false,
    var isInvalidAnaesthetist: Boolean = false,
    var isInvalidAsstDoctor: Boolean = false,
    var isInvalidAsstNurse: Boolean = false,
    var isInvalidRemark: Boolean = false,
)
