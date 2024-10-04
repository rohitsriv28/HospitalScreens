package com.example.hospital.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
@Preview(showSystemUi = true)
@Composable
fun SaveAndDeleteButton() {
    Row (
        Modifier
            .fillMaxWidth()
            .padding(0.dp, 360.dp, 0.dp, 0.dp)){
        Button(onClick = { /*TODO*/ },
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