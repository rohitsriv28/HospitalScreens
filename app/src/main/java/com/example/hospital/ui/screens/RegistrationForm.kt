package com.example.hospital.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
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
import com.example.hospital.presentation.RegUiState
import com.example.hospital.presentation.RegistrationViewModel
import com.example.hospital.ui.components.CustomInputField
import com.example.hospital.ui.components.MyDefaultValues
import com.example.hospital.ui.navigation.Routes

@Composable
fun RegistrationScreen(
    navController: NavHostController,
    viewModel: RegistrationViewModel
) {
    val state: RegUiState = viewModel.registrationUiState
    val navigateToLogin = {
        navController.popBackStack()
        navController.navigate(Routes.LOGIN.path)
    }
    val navigateBack = {
        navController.popBackStack()
        navController.navigate(Routes.LOGIN.path)
    }

    RegistrationForm(
        state,
        viewModel::updateName,
        viewModel::updateEmpId,
        viewModel::updateUserId,
        viewModel::updatePassword,
        viewModel::updatePhone,
        viewModel::updateAddress,
        viewModel::updateEmail,
        navigateToLogin,
        navigateBack
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationForm(
    state: RegUiState,
    updateUserName: (String) -> Unit,
    updateEmpId: (String) -> Unit,
    updateUserId: (String) -> Unit = {},
    updatePassword: (String) -> Unit,
    updatePhone: (String) -> Unit,
    updateAddress: (String) -> Unit,
    updateEmail: (String) -> Unit,
    onRegister: () -> Unit,
    onBack: () -> Unit
) {
    Column(Modifier.padding()) {
        val logo = painterResource(id = R.drawable.hospitallogo)
        //                    <--Input Fields-->

        CenterAlignedTopAppBar(
            title = { Text(text = "Hospital Name") },
            navigationIcon = {
                Icon(
                    painter = logo, contentDescription = "",
                    tint = MyDefaultValues.appBarLogo,
                    modifier = MyDefaultValues.logoSize
                )
            },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = MyDefaultValues.baseColor),
        )
        CenterAlignedTopAppBar(
            navigationIcon = {
                             Icon(imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = "",
                                 modifier = Modifier.clickable { onBack() }.size(40.dp))
            },
            title = { Text(text = "User Registration Form") },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(129, 232, 245, 100))
        )
        Column {

            //            <--BackGround Image-->

            Box {
                Image(
                    painter = painterResource(id = R.drawable.hospitalbackground),
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillBounds,
                    alpha = 0.2F
                )
                Column(
                    Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    //                    <--Input Fields-->

                    CustomInputField(
                        value = state.name,
                        onValueChange = updateUserName,
                        placeholder = "Full Name"
                    )
                    if (state.isInvalidName) {
                        Text(
                            text = "Name is mandatory, and must not end with a space, number or symbol!",
                            color = Color.Red
                        )
                    }

                    Spacer(modifier = MyDefaultValues.defaultSpace)
                    CustomInputField(
                        value = state.empId,
                        onValueChange = updateEmpId,
                        placeholder = "Emp Id"
                    )
                    if (state.isInvalidEmpId) {
                        Text(
                            text = "Employee Id should only contain alphabets and numbers!",
                            color = Color.Red
                        )
                    }

                    Spacer(modifier = MyDefaultValues.defaultSpace)
                    CustomInputField(
                        value = state.userId,
                        onValueChange = updateUserId,
                        placeholder = "User Id"
                    )
                    if (state.isInvalidUserId) {
                        Text(text = "User Id cannot have space or symbols!!", color = Color.Red)
                    }

                    Spacer(modifier = MyDefaultValues.defaultSpace)
                    CustomInputField(
                        value = state.password,
                        onValueChange = updatePassword,
                        placeholder = "Password"
                    )
                    if (state.isInvalidPassword) {
                        Text(
                            text = "Password must be at least 8 characters with an uppercase letter, a lowercase letter, and a numeric value.",
                            color = Color.Red
                        )
                    }

                    Spacer(modifier = MyDefaultValues.defaultSpace)
                    CustomInputField(
                        value = state.phone,
                        onValueChange = updatePhone,
                        placeholder = "Phone"
                    )
                    if (state.isInvalidPhone) {
                        Text(text = "Invalid!! Number exceeds length", color = Color.Red)
                    }

                    Spacer(modifier = MyDefaultValues.defaultSpace)
                    CustomInputField(
                        value = state.address,
                        onValueChange = updateAddress,
                        placeholder = "Address"
                    )
                    if (state.isInvalidAddress) {
                        Text(text = "Limit reached!!", color = Color.Red)
                    }

                    Spacer(modifier = MyDefaultValues.defaultSpace)
                    CustomInputField(
                        value = state.email,
                        onValueChange = updateEmail,
                        placeholder = "Email"
                    )
                    if (state.isInvalidEmail) {
                        Text(text = "Invalid Email Format", color = Color.Red)
                    }

                    Spacer(modifier = Modifier.size(0.dp, 24.dp))

//                    <--SignUp Button-->

                    Button(
                        onClick = onRegister,
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
                        Text(text = "Sign Up")
                    }
                    Spacer(modifier = Modifier.size(0.dp, 24.dp))
                }
            }
        }
    }
}

