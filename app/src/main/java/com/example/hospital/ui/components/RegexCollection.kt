package com.example.hospital.ui.components


fun isAlphabet(testString: String)  = testString.matches(Regex("^[A-Za-z]$"))
fun isInt(testInt: String) = testInt.matches(Regex("^[a-zA-Z0-9]+$"))
//<--LoginPage-->
fun isValidUserName(text: String): Boolean {

    return text.matches(Regex("^[a-zA-Z0-9]+\$"))
}

fun isStrongPassword(password: String): Boolean {
    val passwordRegex = Regex("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{8,}$")
    return passwordRegex.matches(password)
}


//<--Other Registration Forms-->
fun isValidName(name: String): Boolean {
//    return name.matches(Regex("^[A-Za-z]+(?:[\\s.]*[A-Za-z]+)*\$"))
    return name.isNotEmpty() && name.length >= 3 && !name.contains(Regex("\\d"))
}

fun isValidEmpId(empId: String): Boolean {
    return empId.matches(Regex("^[a-zA-Z0-9]+\$"))
}

fun isValidUserId(userId: String): Boolean {
    return userId.matches(Regex("^[a-zA-Z0-9]+\$"))
}

fun isValidPassword(password: String): Boolean {
    return password.matches(Regex("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{8,}\$"))
}

fun isValidPhone(phone: String): Boolean {
    return phone.matches(Regex("^[0-9-\\s]{10}+\$"))
}

fun isValidAddress(address: String): Boolean {

    return address.matches(Regex("^[A-Za-z0-9 .,-]{2,60}\$"))
}

fun isValidEmail(email: String): Boolean {
    return email.matches(Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\$"))
}

fun isValidAge(patientName: String): Boolean = isAlphabet(patientName)

fun isValidSerial(sNo: String): Boolean = isInt(sNo)

fun isValidLP(lpNo: String): Boolean = isInt(lpNo)

fun isValidBedNo(bedNo: String): Boolean = isInt(bedNo)

fun isValidDiagnosis(diagnosis: String): Boolean = isAlphabet(diagnosis)

fun isValidStaff(staff: String): Boolean = isAlphabet(staff)

fun isValidAmount(amount: String): Boolean = isAlphabet(amount)

fun isValidAnaesthetist(anaesthetic: String): Boolean = isAlphabet(anaesthetic)
fun isValidAnaesthesia(anaesthesia: String): Boolean = isAlphabet(anaesthesia)

fun isValidAsstDoctor(asstDoc: String): Boolean = isAlphabet(asstDoc)

fun isValidAsstNurse(asstNurse: String): Boolean = isAlphabet(asstNurse)

fun isValidRemark(remark: String): Boolean = isAlphabet(remark)

fun isValidLogo(companyLogo: String): Boolean = isAlphabet(companyLogo)
fun isValidWebsite(websiteLink: String): Boolean = isAlphabet(websiteLink)
fun isValidRegNo(regNo: String): Boolean = isAlphabet(regNo)
fun isValidLicense(licenseKey: String): Boolean = isAlphabet(licenseKey)
fun isValidMinor(minor: String): Boolean = isAlphabet(minor)
fun isValidMinorCa(minorCa: String): Boolean = isAlphabet(minorCa)
fun isValidDoctor(doctor: String): Boolean = isAlphabet(doctor)
fun isValidCreatedBy(createdBy: String): Boolean = isAlphabet(createdBy)
fun isValidUpdatedBy(updatedBy: String): Boolean = isAlphabet(updatedBy)
fun isValidUpdatedDate(updatedDate: String): Boolean = isAlphabet(updatedDate)
fun isValidStatus(status: String): Boolean = isAlphabet(status)
fun isValidTime(time: String): Boolean = isAlphabet(time)
fun isValidArrivalDate(arrivingDate: String): Boolean = isAlphabet(arrivingDate)
fun isValidDepartingDate(departingDate: String): Boolean = isAlphabet(departingDate)
fun isValidOperationGrade(operationGrade: String): Boolean = isAlphabet(operationGrade)
fun isValidSurgeon(surgeon: String): Boolean = isAlphabet(surgeon)
fun isValidCreatedDate(createdDate: String): Boolean = isAlphabet(createdDate)





