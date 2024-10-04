package com.example.hospital.presentation

data class MoreInfoUiStateSecond(
    var diagnosis: String = "",
    var bedNo: String = "",
    var time: String = "",
    var arrivingDate: String = "",
    var departingDate: String = "",
    var remark: String = "",
    var status: String = "",


    var isInvalidGender: Boolean = false,
    var isInvalidDiagnosis: Boolean = false,
    var isInvalidBedNo: Boolean = false,
    var isInvalidTime: Boolean = false,
    var isInvalidArrivalDate: Boolean = false,
    var isInvalidDepartingDate: Boolean = false,
    var isInvalidRemark: Boolean = false,
    var isInvalidStatus: Boolean = false,
    )
