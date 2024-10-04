package com.example.hospital.presentation

data class EhsUiState(
    var name: String = "",
    var age: String = "",
    var diagnosis: String = "",
    var staff: String = "",
    var amount: String = "",

    var isInvalidName: Boolean = false,
    var isInvalidAge: Boolean = false,
    var isInvalidDiagnosis: Boolean = false,
    var isInvalidStaff: Boolean = false,
    var isInvalidAmount: Boolean = false,
)
