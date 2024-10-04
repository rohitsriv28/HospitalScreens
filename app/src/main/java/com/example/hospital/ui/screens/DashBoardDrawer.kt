package com.example.hospital.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.hospital.ui.components.MyDefaultValues
import com.example.hospital.ui.components.TableComponentEHS
import com.example.hospital.ui.components.TableComponentOT
import com.example.hospital.ui.components.TableComponentPatientEntry
import com.example.hospital.ui.components.TableComponentUsers
import com.example.hospital.ui.navigation.Routes
import com.example.hospital.R

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true)
@Composable
fun DashBoardDrawer(
    navigate: (String) -> Unit = {}
) {
    Column {

        //        <--TopAppBar-->

        TopAppBar(
            title = { Text(text = "DashBoard") },
            navigationIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.hospitallogo),
                    contentDescription = "",
                    tint = MyDefaultValues.appBarLogo,
                    modifier = MyDefaultValues.logoSize
                )
            },
            colors = TopAppBarDefaults.topAppBarColors(MyDefaultValues.baseColor)
        )

        //            <--BackGround Image-->

        Box {
            Image(
                painter = painterResource(id = R.drawable.hospitalbackground),
                contentDescription = "",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxSize(),
                alpha = 0.3f
            )


            //            <--Drawer-->
            ModalNavigationDrawer(drawerContent = {
                Column(Modifier.fillMaxHeight()) {


                    //                    <--User Info-->

                    Box {
                        Row(
                            Modifier
                                .width(240.dp)
                                .background(Color.LightGray)
                                .background(Color.Cyan)
                        ) {
                            Icon(
                                imageVector = Icons.Default.AccountCircle,
                                contentDescription = "",
                                tint = MyDefaultValues.appBarLogo,
                                modifier = Modifier
                                    .size(50.dp, 50.dp)
                                    .padding(8.dp, 0.dp, 0.dp, 0.dp)
                            )
                            Column(Modifier.padding(8.dp, 0.dp, 0.dp, 0.dp)) {
                                Text(text = "UserName", color = Color.Black, fontSize = 24.sp)
                                Row {
                                    Text(
                                        text = "online", color = Color.Black,
                                        fontWeight = FontWeight.SemiBold,
                                        modifier = Modifier.padding(68.dp, 0.dp, 0.dp, 0.dp)
                                    )
                                }
                            }
                        }
                    }

                    //                    <--Drawer Content-->

                    Column(
                        Modifier
                            .width(240.dp)
                            .fillMaxHeight()
                            .background(Color(2, 196, 177, 255))
                    ) {
                        Text(text = "EHS", modifier = Modifier
                            .padding(16.dp, 0.dp, 8.dp, 0.dp)
                            .clickable { navigate(Routes.EHS.path) })
                        Spacer(modifier = MyDefaultValues.defaultSpace)
                        Text(text = "General OT", modifier = Modifier
                            .padding(16.dp, 0.dp, 8.dp, 0.dp)
                            .clickable { navigate(Routes.GENERAL_OT.path) })
                        Spacer(modifier = MyDefaultValues.defaultSpace)
                        Text(text = "Patient Entry", modifier = Modifier
                            .padding(16.dp, 0.dp, 8.dp, 0.dp)
                            .clickable { navigate(Routes.PATIENT_ENTRY.path) })
                        Spacer(modifier = MyDefaultValues.defaultSpace)
                        Text(text = "Company Registration", modifier = Modifier
                            .padding(16.dp, 0.dp, 8.dp, 0.dp)
                            .clickable { navigate(Routes.COMPANY_REGISTRATION.path) })
                        Spacer(modifier = MyDefaultValues.defaultSpace)
                    }
                }
            }) {
                Column {
                    TableComponentEHS()
                    TableComponentPatientEntry()
                    TableComponentOT()
                    TableComponentUsers()
                }

            }
        }
    }
}