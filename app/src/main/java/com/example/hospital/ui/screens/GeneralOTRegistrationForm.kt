package com.example.hospital.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.hospital.R
import com.example.hospital.presentation.OtUiState
import com.example.hospital.presentation.OtViewModel
import com.example.hospital.ui.components.CustomInputField
import com.example.hospital.ui.components.DatePickerTextField
import com.example.hospital.ui.components.GenderDropDown
import com.example.hospital.ui.components.MyDefaultValues
import com.example.hospital.ui.components.OperationGradeDropDown
import com.example.hospital.ui.navigation.Routes


@Composable
fun OTScreen(
    navController: NavHostController,
    viewModel: OtViewModel
) {
    val state: OtUiState = viewModel.otUiState
    val navigateToDashboard = {
        navController.popBackStack()
        navController.navigate(Routes.DASHBOARD.path)
    }
    OperationTheatre(
        state,
        viewModel::updateName,
        viewModel::updateAge,
        viewModel::updateDiagnosis,
        viewModel::updateAnaesthetist,
        viewModel::updateAsstDoctor,
        viewModel::updateAsstNurse,
        viewModel::updateRemark,
        navigateToDashboard
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OperationTheatre(
    state: OtUiState,
    updateName: (String) -> Unit,
    updateAge: (String) -> Unit,
    updateDiagnosis: (String) -> Unit,
    updateAnaesthetist: (String) -> Unit,
    updateAsstDoctor: (String) -> Unit,
    updateAsstNurse: (String) -> Unit,
    updateRemark: (String) -> Unit,
    onSave: () -> Unit
) {


    Column {
        val logo = painterResource(id = R.drawable.hospitallogo)

        //        <--TopAppBar-->

        CenterAlignedTopAppBar(
            title = { Text(text = "General OT Registration") },
            navigationIcon = {
                Icon(
                    painter = logo, contentDescription = "",
                    tint = MyDefaultValues.appBarLogo,
                    modifier = MyDefaultValues.logoSize
                )
            },
            colors = TopAppBarDefaults.topAppBarColors(MyDefaultValues.baseColor)
        )

        //            <--BackGround Image-->

        Box() {
            Image(
                painter = painterResource(id = R.drawable.hospitalbackground),
                contentDescription = "",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds,
                alpha = 0.3f
            )
            Column(
                Modifier
                    .padding(16.dp)
                    .fillMaxHeight()
                    .verticalScroll(rememberScrollState())
            ) {

                //                    <--Input Fields-->

                Text(text = "Name of Patient:", fontSize = 16.sp)
                CustomInputField(
                    value = state.name,
                    onValueChange = updateName,
                    modifier = Modifier.fillMaxWidth()
                )
                if (state.isInvalidName) {
                    Text(text = "This field cannot be empty!!")
                }

                Text(text = "Age:", fontSize = 16.sp)
                CustomInputField(
                    value = state.age,
                    onValueChange = updateAge,
                    modifier = Modifier.fillMaxWidth()
                )
                if (state.isInvalidAge) {
                    Text(text = "This field cannot be empty!!")
                }

                Row(Modifier.fillMaxWidth()) {
                    Column(Modifier.weight(0.3f)) {
                        Text(text = "Gender:", fontSize = 16.sp)
                        GenderDropDown()
                    }
                    Spacer(modifier = Modifier.size(8.dp, 0.dp))
                    Column {
                        Text(text = "Grade of Operation:", fontSize = 16.sp)
                        OperationGradeDropDown()
                    }
                }
                Text(text = "Diagnosis:", fontSize = 16.sp)
                CustomInputField(
                    value = state.diagnosis,
                    onValueChange = updateDiagnosis,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(text = "Operation Date:", fontSize = 16.sp)
                DatePickerTextField()

                Text(text = "Anaesthetist:", fontSize = 16.sp)
                CustomInputField(
                    value = state.anaesthetist,
                    onValueChange = updateAnaesthetist,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(text = "Assistant Doctor:", fontSize = 16.sp)
                CustomInputField(
                    value = state.asstDoctor,
                    onValueChange = updateAsstDoctor,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(text = "Assistant Nurse:", fontSize = 16.sp)
                CustomInputField(
                    value = state.asstNurse,
                    onValueChange = updateAsstNurse,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(text = "Remark:", fontSize = 16.sp)
                CustomInputField(
                    value = state.remark,
                    onValueChange = updateRemark,
                    modifier = Modifier.fillMaxWidth()
                )
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