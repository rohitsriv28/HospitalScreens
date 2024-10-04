package com.example.hospital.presentation

data class CompRegUiState(
    var companyName: String = "" ,
    var companyLogo: String = "" ,
    var websiteLink: String = "" ,
    var regNo: String = "" ,
    var licenseKey: String = "" ,

    var isInvalidName: Boolean = false,
    var isInvalidLogo: Boolean = false,
    var isInvalidWebsiteLink: Boolean = false,
    var isInvalidRegNo: Boolean = false,
    var isInvalidLicense: Boolean = false,
)
