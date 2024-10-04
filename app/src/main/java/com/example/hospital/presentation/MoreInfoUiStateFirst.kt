package com.example.hospital.presentation

data class MoreInfoUiStateFirst(
    var minor: String = "",
    var minorCa: String = "",
    var doctor: String = "",
    var staff: String = "",
    var amount: String = "",
    var createdBy: String = "",
    var updatedBy: String = "",
    var updatedDate: String = "",
    var status: String = "",


    var isInvalidMinor: Boolean = false,
    var isInvalidMinorCa: Boolean = false,
    var isInvalidDoctor: Boolean = false,
    var isInvalidStaff: Boolean = false,
    var isInvalidAmount: Boolean = false,
    var isInvalidCreatedBy: Boolean = false,
    var isInvalidUpdatedBy: Boolean = false,
    var isInvalidUpdatedDate: Boolean = false,
    var isInvalidStatus: Boolean = false,

)
