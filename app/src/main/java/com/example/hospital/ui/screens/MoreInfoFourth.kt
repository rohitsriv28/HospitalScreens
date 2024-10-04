package com.example.hospital.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.hospital.R
import com.example.hospital.presentation.MoreInfoUiStateFourth
import com.example.hospital.presentation.MoreInfoViewModelFourth
import com.example.hospital.ui.components.CustomInputField
import com.example.hospital.ui.navigation.Routes


@Composable
fun MoreInfoScreen4(
    navController: NavHostController,
    viewModel: MoreInfoViewModelFourth
) {
    val state: MoreInfoUiStateFourth = viewModel.moreInfoUiStateFourth
    val navigateToDashboard = {
        navController.navigate(Routes.DASHBOARD.path)
    }
    MoreInfoFourth(
        state,
        viewModel::updateEmail,
        navigateToDashboard
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoreInfoFourth(
    state: MoreInfoUiStateFourth,
    updateEmail: (String) -> Unit,
    onSave: () -> Unit
) {
    Column {
        CenterAlignedTopAppBar(title = { Text(text = "More Info") },
            colors = TopAppBarDefaults.topAppBarColors(Color.Gray))
        Box {
            Image(painter = painterResource(id = R.drawable.hospitalbackground), contentDescription = "",
                modifier = Modifier.fillMaxSize(), contentScale = ContentScale.FillBounds, alpha = 0.3f)
            Column (Modifier.padding(16.dp)){
                CustomInputField(value = state.email, onValueChange = updateEmail, placeholder = "Email:",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 48.dp, 0.dp, 0.dp))
                Row (
                    Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 360.dp, 0.dp, 0.dp)){
                    Button(onClick = onSave,
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0, 150, 136, 255)),
                        shape = ShapeDefaults.ExtraSmall) {
                        Text(text = "Edit")
                    }
                    Spacer(modifier = Modifier.weight(0.6f))
                    Button(onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(255, 0, 0, 255)),
                        shape = ShapeDefaults.ExtraSmall) {
                        Text(text = "Delete")
                    }
                }
            }
        }
    }
}