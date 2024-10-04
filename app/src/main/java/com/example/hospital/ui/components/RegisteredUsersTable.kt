package com.example.hospital.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun TableComponentUsers() {

    data class PatientEntry(
        val serial: Int,
        val lpNo: Int,
        val eo_pdNo: Int,
        val patientName: String,
        val address: String,
        val detail: String
    )

    val patientList = listOf<PatientEntry>(
        PatientEntry(1, 1234, 545667, "Tony Stark", "New York", "View"),
        PatientEntry(2, 1236, 567562, "Bruce Wayne", "Gotham City", "View"),
        PatientEntry(3, 1239, 567990, "Steve Rogers", "Queens", "View"),
        PatientEntry(4, 1231, 567344, "Barry Allen", "Central City", "View"),
        PatientEntry(5, 1233, 567677, "Black Adam", "Khandaq", "View"),
        PatientEntry(6, 1232, 567231, "AquaMan", "Atlantis", "View"),
    )

    Column(
        Modifier
            .fillMaxSize()) {
        Card(
            Modifier.padding(0.dp, 16.dp, 0.dp, 0.dp),
            colors = CardDefaults.cardColors(Color(0, 188, 212, 30))) {
            Column(Modifier.horizontalScroll(rememberScrollState())) {
                Text(text = "Registered Users", modifier = Modifier.padding(12.dp, 8.dp,0.dp,8.dp)
                    /*.background(Color(0, 188, 212, 150))*/)
                Row {
                    Text(text = "S.No", modifier = Modifier
                        .padding(8.dp)
                        .width(36.dp), fontWeight = FontWeight.Bold)
                    Text(text = "LP No.", modifier = Modifier
                        .padding(8.dp)
                        .width(48.dp), fontWeight = FontWeight.Bold)
                    Text(text = "EOPD No.", modifier = Modifier
                        .padding(8.dp)
                        .width(64.dp), fontWeight = FontWeight.Bold)
                    Text(text = "Patient Name", modifier = Modifier
                        .padding(8.dp)
                        .width(100.dp), fontWeight = FontWeight.Bold)
                    Text(text = "Address", modifier = Modifier
                        .padding(8.dp)
                        .width(90.dp), fontWeight = FontWeight.Bold)
                    Text(text = "Details", modifier = Modifier
                        .padding(8.dp)
                        .width(48.dp), fontWeight = FontWeight.Bold)
                }

                patientList.forEach() {
                    Row {
                        Text(text = it.serial.toString(), textAlign = TextAlign.Center,modifier = Modifier
                            .padding(8.dp)
                            .width(36.dp))
                        Text(text = it.lpNo.toString(), textAlign = TextAlign.Center, modifier = Modifier
                            .padding(8.dp)
                            .width(48.dp),)
                        Text(text = it.eo_pdNo.toString(), textAlign = TextAlign.Center, modifier = Modifier
                            .padding(8.dp)
                            .width(64.dp))
                        Text(text = it.patientName, textAlign = TextAlign.Center, modifier = Modifier
                            .padding(8.dp)
                            .width(90.dp))
                        Text(text = it.address, textAlign = TextAlign.Center, modifier = Modifier
                            .padding(8.dp)
                            .width(90.dp))
                        Text(text = it.detail, textAlign = TextAlign.Center, modifier = Modifier
                            .padding(8.dp)
                            .width(48.dp))
                    }
                }
            }
        }
    }
}