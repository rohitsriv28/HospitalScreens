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
import androidx.navigation.NavHostController
import com.example.hospital.R
import com.example.hospital.presentation.MoreInfoUiStateSecond
import com.example.hospital.presentation.MoreInfoViewModelSecond
import com.example.hospital.ui.components.CustomInputField
import com.example.hospital.ui.components.MyDefaultValues
import com.example.hospital.ui.navigation.Routes


@Composable
fun MoreInfoScreen2(
    navController: NavHostController,
    viewModel: MoreInfoViewModelSecond
) {
    val state: MoreInfoUiStateSecond = viewModel.moreInfoUiStateSecond
    val navigateToDashboard = {
        navController.navigate(Routes.DASHBOARD.path)
    }
    MoreInfoSecond(
        state,
        viewModel::updateDiagnosis,
        viewModel::updateBedNo,
        viewModel::updateTime,
        viewModel::updateArrivalDate,
        viewModel::updateDepartureDate,
        viewModel::updateRemark,
        viewModel::updateStatus,
        navigateToDashboard
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoreInfoSecond(
    state: MoreInfoUiStateSecond,
    updateDiagnosis: (String) -> Unit,
    updateBedNo: (String) -> Unit,
    updateTime: (String) -> Unit,
    updateArrivalDate: (String) -> Unit,
    updateDepartureDate: (String) -> Unit,
    updateRemark: (String) -> Unit,
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
                Modifier
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                FullWidthGenderDropDown()
                Spacer(modifier = MyDefaultValues.defaultSpace)
                CustomInputField(
                    value = state.diagnosis,
                    onValueChange = updateDiagnosis,
                    placeholder = "Diagnosis:",
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = MyDefaultValues.defaultSpace)
                CustomInputField(
                    value = state.bedNo,
                    onValueChange = updateBedNo,
                    placeholder = "Bed No:",
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = MyDefaultValues.defaultSpace)
                CustomInputField(
                    value = state.time,
                    onValueChange = updateTime,
                    placeholder = "Time:",
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = MyDefaultValues.defaultSpace)
                CustomInputField(
                    value = state.arrivingDate,
                    onValueChange = updateArrivalDate,
                    placeholder = "Date of Arrival:",
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = MyDefaultValues.defaultSpace)
                CustomInputField(
                    value = state.departingDate,
                    onValueChange = updateDepartureDate,
                    placeholder = "Date of Discharge:",
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = MyDefaultValues.defaultSpace)
                CustomInputField(
                    value = state.remark,
                    onValueChange = updateRemark,
                    placeholder = "Remark:",
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