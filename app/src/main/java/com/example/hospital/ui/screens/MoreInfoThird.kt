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
import com.example.hospital.presentation.MoreInfoUiStateThird
import com.example.hospital.presentation.MoreInfoViewModelThird
import com.example.hospital.ui.components.CustomInputField
import com.example.hospital.ui.components.MyDefaultValues
import com.example.hospital.ui.navigation.Routes


@Composable
fun MoreInfoScreen3(
    navController: NavHostController,
    viewModel: MoreInfoViewModelThird
) {
    val state: MoreInfoUiStateThird = viewModel.moreInfoUiStateThird
    val navigateToDashboard = {
        navController.navigate(Routes.DASHBOARD.path)
    }
    MoreInfoThird(
        state,
        viewModel::updateOperationGrade,
        viewModel::updateAnaesthetist,
        viewModel::updateAnaesthesia,
        viewModel::updateSurgeon,
        viewModel::updateAsstDoc,
        viewModel::updateAsstNurse,
        viewModel::updateCreatedDate,
        viewModel::updateCreatedBy,
        viewModel::updateUpdatedBy,
        viewModel::updateUpdatedDate,
        viewModel::updateStatus,
        navigateToDashboard
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoreInfoThird(
    state: MoreInfoUiStateThird,
    updateOperationGrade: (String) -> Unit,
    updateAnaesthetist: (String) -> Unit,
    updateAnaesthesia: (String) -> Unit,
    updateSurgeon: (String) -> Unit,
    updateAsstDoc: (String) -> Unit,
    updateAsstNurse: (String) -> Unit,
    updateCreatedDate: (String) -> Unit,
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
                contentDescription = "",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds, alpha = 0.3f
            )
            Column(
                Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp)
            ) {
                CustomInputField(
                    value = state.operationGrade,
                    onValueChange = updateOperationGrade,
                    placeholder = "Grade of Operation:"
                )
                Spacer(modifier = MyDefaultValues.defaultSpace)
                CustomInputField(
                    value = state.anaesthetist,
                    onValueChange = updateAnaesthetist,
                    placeholder = "Anaesthetist:"
                )
                Spacer(modifier = MyDefaultValues.defaultSpace)
                CustomInputField(
                    value = state.anaesthesia,
                    onValueChange = updateAnaesthesia,
                    placeholder = "Anaesthesia:"
                )
                Spacer(modifier = MyDefaultValues.defaultSpace)
                CustomInputField(
                    value = state.surgeon,
                    onValueChange = updateSurgeon,
                    placeholder = "Surgeon:"
                )
                Spacer(modifier = MyDefaultValues.defaultSpace)
                CustomInputField(
                    value = state.asstDoc,
                    onValueChange = updateAsstDoc,
                    placeholder = "Assistant Dr.:"
                )
                Spacer(modifier = MyDefaultValues.defaultSpace)
                CustomInputField(
                    value = state.asstNurse,
                    onValueChange = updateAsstNurse,
                    placeholder = "Assistant Nurse:"
                )
                Spacer(modifier = MyDefaultValues.defaultSpace)
                CustomInputField(
                    value = state.createdDate,
                    onValueChange = updateCreatedDate,
                    placeholder = "Created Date:"
                )
                Spacer(modifier = MyDefaultValues.defaultSpace)
                CustomInputField(
                    value = state.createdBy,
                    onValueChange = updateCreatedBy,
                    placeholder = "Created By:"
                )
                Spacer(modifier = MyDefaultValues.defaultSpace)
                CustomInputField(
                    value = state.updatedBy,
                    onValueChange = updateUpdatedBy,
                    placeholder = "Updated By:"
                )
                Spacer(modifier = MyDefaultValues.defaultSpace)
                CustomInputField(
                    value = state.updatedDate,
                    onValueChange = updateUpdatedDate,
                    placeholder = "Updated Date:"
                )
                Spacer(modifier = MyDefaultValues.defaultSpace)
                CustomInputField(
                    value = state.status,
                    onValueChange = updateStatus,
                    placeholder = "Status:"
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
