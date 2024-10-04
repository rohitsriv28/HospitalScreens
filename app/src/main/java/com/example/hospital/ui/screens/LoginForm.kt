package com.example.hospital.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hospital.R
import com.example.hospital.ui.components.CustomInputField
import com.example.hospital.ui.components.MyDefaultValues
import com.example.hospital.ui.components.isStrongPassword
import com.example.hospital.ui.components.isValidUserName
import com.example.hospital.ui.navigation.Routes

@OptIn(ExperimentalMaterial3Api::class)
//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreen(
    onNavigation: (String, Boolean) -> Unit

) {
    var userName by remember { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var isInvalidUser by remember { mutableStateOf(false) }
    var isInvalidPassword by remember { mutableStateOf(false) }
    Column(
        Modifier
            .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
    ) {

        //        <--TopAppBar-->

        CenterAlignedTopAppBar(colors = TopAppBarDefaults.topAppBarColors(containerColor = MyDefaultValues.baseColor),
            title = { Text(text = "LOGIN FORM") })
        Column(
            Modifier
                .fillMaxHeight()
                .padding(16.dp), verticalArrangement = Arrangement.Center
        ) {

            //            <--BackGround Image-->

            Box(contentAlignment = Alignment.Center) {
                Image(
                    painter = painterResource(id = R.drawable.hospitallogo),
                    contentDescription = "BackGround Image",
                    alpha = 0.1F,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Fit
                )
                Column(verticalArrangement = Arrangement.Center) {

                    //                    <--Input Fields-->
                    CustomInputField(
                        value = userName,
                        onValueChange = { input ->
                            userName = input
                            isInvalidUser = userName.isNotEmpty() && !isValidUserName(userName)
                        },
                        placeholder = "User Name",
                        isError = isInvalidUser,
                        modifier = Modifier.fillMaxWidth(),
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.AccountBox,
                                contentDescription = "",
                                tint = MyDefaultValues.baseColor
                            )
                        },
                        iconColor = MyDefaultValues.baseColor
                    )
                    if (isInvalidUser) {
                        Text(text = "Input text is invalid!!", color = Color.Red)
                    }

                    Spacer(modifier = MyDefaultValues.defaultSpace)
                    CustomInputField(
                        value = password,
                        onValueChange = { input ->
                            password = input
                            isInvalidPassword = password.isNotEmpty() && !isStrongPassword(password)
                        },
                        placeholder = "Password",
                        isError = isInvalidPassword,
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Lock,
                                contentDescription = "",
                                tint = MyDefaultValues.baseColor
                            )
                        },
                        modifier = Modifier.fillMaxWidth(),
                        iconColor = MyDefaultValues.baseColor
                    )
                    if (isInvalidPassword) {
                        Text(
                            text = "Password must be at least 8 characters with an uppercase letter, a lowercase letter, and a digit.",
                            color = Color.Red
                        )
                    }

                    Spacer(modifier = Modifier.size(0.dp, 16.dp))
                    Text(text = "Forgot Password", modifier = Modifier.clickable { })
                    Spacer(modifier = MyDefaultValues.defaultSpace)

//                    <--Login Button-->

                    OutlinedButton(
                        onClick = { onNavigation(Routes.DASHBOARD.path, true) },
                        colors = ButtonDefaults.buttonColors(containerColor = MyDefaultValues.baseColor),
                        modifier = Modifier.fillMaxWidth(),
                        shape = ShapeDefaults.Small
                    ) {
                        Text(text = "Login")
                    }
                    Spacer(modifier = MyDefaultValues.defaultSpace)
                    Row {
                        Text(
                            text = "Not a member?\t",
                            fontWeight = FontWeight.SemiBold,
                            textAlign = TextAlign.Justify
                        )
                        Text(text = "SignUp now",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            textAlign = TextAlign.Justify,
                            color = Color(14, 121, 178, 255),
                            textDecoration = TextDecoration.Underline,
                            modifier = Modifier.clickable {
                                onNavigation(Routes.REGISTRATION.path, true)
                            }
                        )
                    }
                }
            }
        }
    }
}

