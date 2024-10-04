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
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hospital.R
import com.example.hospital.ui.components.MyDefaultValues
import com.example.hospital.ui.navigation.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true)
@Composable
fun HomeScreen(
    navigate: (String) -> Unit = {}
) {
    Column(Modifier.padding()) {
        val logo = painterResource(id = R.drawable.hospitallogo)

        //        <--TopAppBar-->

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

        //            <--BackGround Image-->

        Box {
            Image(
                painter = painterResource(id = R.drawable.hospitallogo), contentDescription = "",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Fit, alpha = 0.7F
            )
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 360.dp, 0.dp, 0.dp),
                horizontalArrangement = Arrangement.Center
            ) {

                //                    <--Button-->

                Button(
                    onClick = { navigate(Routes.LOGIN.path) },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(140, 26, 106, 255)),
                    shape = ShapeDefaults.ExtraSmall
                ) {
                    Text(text = "Login")
                }
                Spacer(modifier = Modifier.width(45.dp))
                Button(
                    onClick = { navigate("RegistrationForm") },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(140, 26, 106, 255)),
                    shape = ShapeDefaults.ExtraSmall
                ) {
                    Text(text = "SignUp")
                }
            }
        }
    }
}