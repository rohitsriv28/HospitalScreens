package com.example.hospital.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hospital.R
import com.example.hospital.presentation.PatientEntryUiState
import com.example.hospital.presentation.PatientEntryViewModel
import com.example.hospital.ui.components.CustomInputField
import com.example.hospital.ui.components.DatePickerTextField
import com.example.hospital.ui.components.MyDefaultValues
import com.example.hospital.ui.navigation.Routes

@Composable
fun PatientEntryScreen(
    navController: NavController,
    viewModel: PatientEntryViewModel

) {
    val state: PatientEntryUiState = viewModel.patientEntryUiState
    val navigateToDashboard = {
        navController.popBackStack()
        navController.navigate(Routes.DASHBOARD.path)
    }
    PatientEntry(
        state,
        viewModel::updateSno,
        viewModel::updateLpNo,
        viewModel::updateName,
        viewModel::updateAddress,
        viewModel::updateDiagnosis,
        viewModel::updateBedNo,
        navigateToDashboard
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PatientEntry(
    state: PatientEntryUiState,
    updateSno: (String) -> Unit,
    updateLpNo: (String) -> Unit,
    updateName: (String) -> Unit,
    updateAddress: (String) -> Unit,
    updateDiagnosis: (String) -> Unit,
    updateBedNo: (String) -> Unit,
    onSave: () -> Unit
) {

    Column {
        val logo = painterResource(id = R.drawable.hospitallogo)

        //        <--TopAppBar-->

        CenterAlignedTopAppBar(
            title = { Text(text = "Patient Entry") },
            navigationIcon = {
                Icon(
                    painter = logo, contentDescription = "",
                    tint = MyDefaultValues.appBarLogo,
                    modifier = MyDefaultValues.logoSize
                )
            },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = MyDefaultValues.baseColor)
        )

        //            <--BackGround Image-->

        Box {
            Image(
                painter = painterResource(id = R.drawable.hospitalbackground),
                contentDescription = "",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds,
                alpha = 0.3f
            )
            Column(
                Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp)
            ) {

                //                    <--Input Fields-->

                Text(text = "S.No.", fontSize = 16.sp)
                CustomInputField(
                    value = state.sNo,
                    onValueChange = updateSno,
                    modifier = Modifier.fillMaxWidth()
                )
                if (state.isInvalidSerial) {
                    Text(
                        text = "This field cannot be empty. Holds only numeric value!!",
                        color = Color.Red
                    )
                }

                Text(text = "LP No.", fontSize = 16.sp)
                CustomInputField(
                    value = state.lpNo,
                    onValueChange = updateLpNo,
                    modifier = Modifier.fillMaxWidth()
                )
                if (state.isInvalidLpNo) {
                    Text(text = "This field cannot be empty!!", color = Color.Red)
                }

                Text(text = "Patient Name", fontSize = 16.sp)
                CustomInputField(
                    value = state.name,
                    onValueChange = updateName,
                    modifier = Modifier.fillMaxWidth()
                )
                if (state.isInvalidName) {
                    Text(text = "This field cannot be empty!!", color = Color.Red)
                }

                Text(text = "Gender", fontSize = 16.sp)
                Column(Modifier.fillMaxWidth()) {
                    FullWidthGenderDropDown()
                }
                Text(text = "Address", fontSize = 16.sp)
                CustomInputField(
                    value = state.address,
                    onValueChange = updateAddress,
                    modifier = Modifier.fillMaxWidth()
                )
                if (state.isInvalidAddress) {
                    Text(text = "This field cannot be empty!!", color = Color.Red)
                }

                Text(text = "Diagnosis", fontSize = 16.sp)
                CustomInputField(
                    value = state.diagnosis,
                    onValueChange = updateDiagnosis,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(text = "Date of Arrival", fontSize = 16.sp)
                DatePickerTextField()

                Text(text = "Bed No.", fontSize = 16.sp)
                CustomInputField(
                    value = state.bedNo,
                    onValueChange = updateBedNo,
                    modifier = Modifier.fillMaxWidth()
                )
                if (state.isInvalidBedNo) {
                    Text(text = "This field cannot be empty!!", color = Color.Red)
                }

                Spacer(modifier = MyDefaultValues.defaultSpace)
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {

                    //                    <--Button-->

                    Button(
                        onClick = onSave,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(
                                0,
                                150,
                                136,
                                255
                            )
                        ),
                        shape = ShapeDefaults.ExtraSmall
                    ) {
                        Text(text = "Save")
                    }
                }
            }
        }
    }
}


//          <--Gender DropDown Menu-->
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FullWidthGenderDropDown() {
    val options = listOf("Select", "Male", "Female", "Others")
    var isExpanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf(options[0]) }

    ExposedDropdownMenuBox(
        expanded = isExpanded,
        onExpandedChange = { isExpanded = it },
    ) {
        OutlinedTextField(
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth(),
            value = selectedOptionText,
            onValueChange = {},
            readOnly = true,
//            label = { Text("Gender")},
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded) },
            colors = ExposedDropdownMenuDefaults.outlinedTextFieldColors(),
            shape = ShapeDefaults.Medium
        )
        ExposedDropdownMenu(modifier = Modifier
            .background(Color.White)
            .fillMaxWidth(),
            expanded = isExpanded,
            onDismissRequest = { isExpanded = false }) {
            options.forEach { selectionOption ->
                DropdownMenuItem(
                    text = { Text(selectionOption) },
                    onClick = {
                        selectedOptionText = selectionOption
                        isExpanded = false
                    },
                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                )
            }
        }
    }
}
