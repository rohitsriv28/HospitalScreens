package com.example.hospital.presentation

data class RegUiState(
    var name: String = "",
    var empId: String = "",
    var userId: String = "",
    var password: String = "",
    var phone: String = "",
    var address: String = "",
    var email: String = "",

    var isInvalidName: Boolean = false,
    var isInvalidEmpId: Boolean = false,
    var isInvalidUserId: Boolean = false,
    var isInvalidPassword: Boolean = false,
    var isInvalidPhone: Boolean = false,
    var isInvalidAddress: Boolean = false,
    var isInvalidEmail: Boolean = false,
)
