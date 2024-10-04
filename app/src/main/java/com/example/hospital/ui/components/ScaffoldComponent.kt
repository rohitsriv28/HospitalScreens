package com.example.hospital.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.hospital.R
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun SnackBarDemo() {
    val logo = painterResource(id = R.drawable.hospitallogo)
    val scope = rememberCoroutineScope()
    val snackBarHostState = remember { SnackbarHostState() }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = { Text(text = "Scaffold Demo") },
                navigationIcon = { Icon(painter = logo, contentDescription = "",
                    tint = MyDefaultValues.appBarLogo,
                    modifier = MyDefaultValues.logoSize)
                },
                colors = TopAppBarDefaults.topAppBarColors(MyDefaultValues.baseColor)
            )
        },
        bottomBar = { BottomAppBar {} },
        snackbarHost = {
            SnackbarHost(hostState = snackBarHostState) {
                Snackbar(snackbarData = snackBarHostState.currentSnackbarData!!)
            }
        }
    ) { paddingValues ->
        Column(Modifier.padding(paddingValues)) {
            Button(onClick = {
                scope.launch {
                    snackBarHostState.showSnackbar("Notification Deleted", "Undo",
                        duration = SnackbarDuration.Short)
                }
            }) {
                Text(text = "Click Here!")
            }
        }

    }
}