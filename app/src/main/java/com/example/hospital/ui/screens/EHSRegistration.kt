package com.example.hospital.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import com.example.hospital.presentation.EhsUiState
import com.example.hospital.presentation.EhsViewModel
import com.example.hospital.ui.components.CustomInputField
import com.example.hospital.ui.components.DatePickerTextField
import com.example.hospital.ui.components.GenderDropDown
import com.example.hospital.ui.components.MyDefaultValues
import com.example.hospital.ui.components.OperationGradeDropDown
import com.example.hospital.ui.navigation.Routes

//import kotlin.coroutines.jvm.internal.CompletedContinuation.context

@Composable
fun EhsRegistrationScreen(
    navController: NavHostController,
    viewModel: EhsViewModel
) {
    val state: EhsUiState = viewModel.ehsUiState
    val navigateToDashboard = {
        navController.popBackStack()
        navController.navigate(Routes.DASHBOARD.path)
    }
    EhsRegistration(
        state,
        viewModel::updateName,
        viewModel::updateAge,
        viewModel::updateDiagnosis,
        viewModel::updateStaff,
        viewModel::updateAmount,
        navigateToDashboard
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EhsRegistration(
    state: EhsUiState,
    updateName: (String) -> Unit,
    updateAge: (String) -> Unit,
    updateDiagnosis: (String) -> Unit,
    updateStaff: (String) -> Unit,
    updateAmount: (String) -> Unit,
    onSave: () -> Unit

) {


    Column {
        val logo = painterResource(id = R.drawable.hospitallogo)
        CenterAlignedTopAppBar(
            title = { Text(text = "EHS Registration") },
            navigationIcon = {
                Icon(
                    painter = logo, contentDescription = "",
                    tint = MyDefaultValues.appBarLogo,
                    modifier = MyDefaultValues.logoSize
                )
            },
            colors = TopAppBarDefaults.topAppBarColors(MyDefaultValues.baseColor)
        )
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
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Text(text = "Name of Patient:", fontSize = 16.sp)
                CustomInputField(
                    value = state.name,
                    onValueChange = updateName,
                    modifier = Modifier.fillMaxWidth()
                )
                if (state.isInvalidName) {
                    Text(
                        text = "This field cannot be empty!!",
                        color = Color.Red
                    )
                }

                Text(text = "Age:", fontSize = 16.sp)
                CustomInputField(
                    value = state.age,
                    onValueChange = updateAge,
                    modifier = Modifier.fillMaxWidth()
                )
                if (state.isInvalidAge) {
                    Text(
                        text = "This field cannot be empty!!",
                        color = Color.Red
                    )
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
                if (state.isInvalidDiagnosis) {
                    Text(
                        text = "This field cannot be empty!!",
                        color = Color.Red
                    )
                }

                Text(text = "Operation Date:", fontSize = 16.sp)
                DatePickerTextField()


                Text(text = "Staff:", fontSize = 16.sp)
                CustomInputField(
                    value = state.staff,
                    onValueChange = updateStaff,
                    modifier = Modifier.fillMaxWidth()
                )
                if (state.isInvalidStaff) {
                    Text(
                        text = "This field cannot be empty!!",
                        color = Color.Red
                    )
                }


                Text(text = "Amount:", fontSize = 16.sp)
                CustomInputField(
                    value = state.amount,
                    onValueChange = updateAmount,
                    modifier = Modifier.fillMaxWidth()
                )
                if (state.isInvalidAmount) {
                    Text(
                        text = "This field cannot be empty!!",
                        color = Color.Red
                    )
                }


                Text(text = "Date:", fontSize = 16.sp)
                DatePickerTextField()
                Spacer(modifier = MyDefaultValues.defaultSpace)
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
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


