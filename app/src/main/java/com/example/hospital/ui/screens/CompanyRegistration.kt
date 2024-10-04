package com.example.hospital.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.hospital.R
import com.example.hospital.presentation.CompRegUiState
import com.example.hospital.presentation.CompRegViewModel
import com.example.hospital.ui.components.CustomInputField
import com.example.hospital.ui.components.MyDefaultValues
import com.example.hospital.ui.navigation.Routes

@Composable
fun CompanyRegistrationScreen(
    navController: NavHostController,
    viewModel: CompRegViewModel
) {
    val state: CompRegUiState = viewModel.compRegUiState
    val navigateToDashboard = {
        navController.popBackStack()
        navController.navigate(Routes.DASHBOARD.path)
    }

    CompanyRegistration(
        state,
        viewModel::updateName,
        viewModel::updateLogo,
        viewModel::updateWebsiteLink,
        viewModel::updateRegNo,
        viewModel::updateLicenseKey,
        navigateToDashboard
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CompanyRegistration(
    state: CompRegUiState,
    updateName: (String) -> Unit,
    updateLogo: (String) -> Unit,
    updateWebsiteLink: (String) -> Unit,
    updateRegNo: (String) -> Unit,
    updateLicenseKey: (String) -> Unit,
    onSave: () -> Unit
) {
    Column {
        val logo = painterResource(id = R.drawable.hospitallogo)

        //        <--TopAppBar-->

        CenterAlignedTopAppBar(
            title = { Text(text = "Company Registration") },
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
                    .fillMaxWidth()
                    .padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally
            ) {

                //                    <--Input Fields-->

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "Name Of Company:", modifier = Modifier.weight(0.4f))
                    CustomInputField(
                        value = state.companyName,
                        onValueChange = updateName,
                        modifier = Modifier.weight(0.8f)
                    )
                }
                Spacer(modifier = MyDefaultValues.defaultSpace)
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "Logo:", modifier = Modifier.weight(0.4f))
                    CustomInputField(
                        value = state.companyLogo,
                        onValueChange = updateLogo,
                        modifier = Modifier.weight(0.8f)
                    )
                }
                Spacer(modifier = MyDefaultValues.defaultSpace)
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "Website Link:", modifier = Modifier.weight(0.4f))
                    CustomInputField(
                        value = state.websiteLink,
                        onValueChange = updateWebsiteLink,
                        modifier = Modifier.weight(0.8f)
                    )
                }
                Spacer(modifier = MyDefaultValues.defaultSpace)
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "Registration No.:", modifier = Modifier.weight(0.4f))
                    CustomInputField(
                        value = state.regNo,
                        onValueChange = updateRegNo,
                        modifier = Modifier.weight(0.8f)
                    )
                }
                Spacer(modifier = MyDefaultValues.defaultSpace)
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "License Key:", modifier = Modifier.weight(0.4f))
                    CustomInputField(
                        value = state.licenseKey,
                        onValueChange = updateLicenseKey,
                        modifier = Modifier.weight(0.8f)
                    )
                }
                Spacer(modifier = Modifier.size(0.dp, 24.dp))

                //                    <--Button-->

                Button(
                    onClick = onSave,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0, 150, 136, 255)),
                    shape = ShapeDefaults.ExtraSmall
                ) {
                    Text(text = "Save")
                }
                Spacer(modifier = Modifier.size(0.dp, 24.dp))
            }
        }
    }
}