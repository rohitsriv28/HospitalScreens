package com.example.hospital.ui.screens

import androidx.compose.foundation.Image
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.hospital.R
import com.example.hospital.presentation.MoreInfoUiStateFirst
import com.example.hospital.presentation.MoreInfoViewModelFirst
import com.example.hospital.ui.components.CustomInputField
import com.example.hospital.ui.components.MyDefaultValues
import com.example.hospital.ui.navigation.Routes


@Composable
fun MoreInfoScreen1(
    navController: NavController,
    viewModel: MoreInfoViewModelFirst
) {
    val state: MoreInfoUiStateFirst = viewModel.moreInfoUiStateFirst
    val navigateToDashboard = {
        navController.navigate(Routes.DASHBOARD.path)
    }
    MoreInfoFirst(
        state,
        viewModel::updateMinor,
        viewModel::updateMinorCa,
        viewModel::updateDoctor,
        viewModel::updateStaff,
        viewModel::updateAmount,
        viewModel::updateCreatedBy,
        viewModel::updateUpdatedBy,
        viewModel::updateUpdatedDate,
        viewModel::updateStatus,
        navigateToDashboard
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoreInfoFirst(
    state: MoreInfoUiStateFirst,
    updateMinor: (String) -> Unit,
    updateMinorCa: (String) -> Unit,
    updateDoctor: (String) -> Unit,
    updateStaff: (String) -> Unit,
    updateAmount: (String) -> Unit,
    updateCreatedBy: (String) -> Unit,
    updateUpdatedBy: (String) -> Unit,
    updateUpdatedDate: (String) -> Unit,
    updateStatus: (String) -> Unit,
    onSave: () -> Unit
) {
    Column {
        CenterAlignedTopAppBar(
            title = { Text(text = "More Info", fontWeight = FontWeight.ExtraBold) },
            colors = TopAppBarDefaults.topAppBarColors(Color.Gray)
        )
        Box() {
            Image(
                painter = painterResource(id = R.drawable.hospitalbackground),
                contentDescription = "", modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds, alpha = 0.2f
            )
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                FullWidthGenderDropDown()
                Spacer(modifier = MyDefaultValues.defaultSpace)
                CustomInputField(
                    value = state.minor,
                    onValueChange = updateMinor,
                    placeholder = "Minor:",
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = MyDefaultValues.defaultSpace)
                CustomInputField(
                    value = state.minorCa,
                    onValueChange = updateMinorCa,
                    placeholder = "Minor CA:",
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = MyDefaultValues.defaultSpace)
                CustomInputField(
                    value = state.doctor,
                    onValueChange = updateDoctor,
                    placeholder = "Doctor:",
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = MyDefaultValues.defaultSpace)
                CustomInputField(
                    value = state.staff,
                    onValueChange = updateStaff,
                    placeholder = "Staff:",
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = MyDefaultValues.defaultSpace)
                CustomInputField(
                    value = state.amount,
                    onValueChange = updateAmount,
                    placeholder = "Amount:",
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = MyDefaultValues.defaultSpace)
                CustomInputField(
                    value = state.createdBy,
                    onValueChange = updateCreatedBy,
                    placeholder = "Created By:",
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = MyDefaultValues.defaultSpace)
                CustomInputField(
                    value = state.updatedBy,
                    onValueChange = updateUpdatedBy,
                    placeholder = "Updated By:",
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = MyDefaultValues.defaultSpace)
                CustomInputField(
                    value = state.updatedDate,
                    onValueChange = updateUpdatedDate,
                    placeholder = "Updated Date:",
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = MyDefaultValues.defaultSpace)
                CustomInputField(
                    value = state.status,
                    onValueChange = updateStatus,
                    placeholder = "Status:",
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = MyDefaultValues.defaultSpace)
                Row(Modifier.fillMaxWidth()) {
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
                        Text(text = "Edit")
                    }
                    Spacer(modifier = Modifier.weight(0.6f))
                    Button(
                        onClick = {  },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(
                                255,
                                0,
                                0,
                                255
                            )
                        ),
                        shape = ShapeDefaults.ExtraSmall
                    ) {
                        Text(text = "Delete")
                    }
                }
            }
        }
    }
}