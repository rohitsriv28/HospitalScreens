package com.example.hospital.presentation

data class PatientEntryUiState(
    var sNo: String = "",
    var lpNo: String = "",
    var name: String = "",
    var address: String = "",
    var diagnosis: String = "",
    var bedNo: String = "",

    var isInvalidSerial: Boolean = false,
    var isInvalidLpNo: Boolean = false,
    var isInvalidName: Boolean = false,
    var isInvalidAddress: Boolean = false,
    var isInvalidDiagnosis: Boolean = false,
    var isInvalidBedNo: Boolean = false,
)
