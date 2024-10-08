package com.example.hospital.ui.components

import android.icu.text.SimpleDateFormat
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerFormatter
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import kotlinx.coroutines.launch
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true)
@Composable
fun DatePickerTextField() {

    val datePickerState = rememberDatePickerState(
        initialDisplayMode = DisplayMode.Picker,
    )
    var text by remember { mutableStateOf("") }
    var openDialog by remember { mutableStateOf(false) }

    val snackState = remember {
        SnackbarHostState()
    }
    val snackScope = rememberCoroutineScope()

    val confirmEnabled = remember {
        derivedStateOf { datePickerState.selectedDateMillis != null }
    }
    val date = Date()
    val sdf = SimpleDateFormat("dd-MM-yyyy")

    val formattedDate = sdf.format(date)

    OutlinedTextField(
        value = text,
        onValueChange = {
            text = it
        },
        placeholder = {
            Text(text = formattedDate)
        },
        modifier = Modifier.fillMaxWidth(),
        shape = ShapeDefaults.Medium,
        trailingIcon = {
            IconButton(onClick = {
                openDialog = true
            }) {
                Icon(imageVector = Icons.Default.DateRange, contentDescription = "Calendar")
            }
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                // Handle Done button click if needed
            }
        )
    )

    if (openDialog) {
        Dialog(
            onDismissRequest = {
                openDialog = false
            },
            properties = DialogProperties(dismissOnBackPress = false)
        ) {
            DatePickerDialog(
                onDismissRequest = {
                    openDialog = false
                },
                confirmButton = {
                    TextButton(
                        {
                            // Convert selectedDateMillis to Date format
                            val selectedDate = datePickerState.selectedDateMillis?.let {
                                Date(it)
                            }

                            // Format the Date to your desired format
                            val dateFormat = SimpleDateFormat("dd-MM-yyyy")
                            val formattedDate = selectedDate?.let {
                                dateFormat.format(it)
                            }

                            text = formattedDate ?: "Invalid Date"
                            openDialog = false

                            snackScope.launch {
                                snackState.showSnackbar(
                                    "Selected date: ${formattedDate ?: "Invalid Date"}"
                                )
                            }
                        },
                        enabled = confirmEnabled.value
                    ) {
                        Text(text = "Ok")
                    }
                },
                dismissButton = {
                    TextButton(onClick = {
                        openDialog = false
                    }) {
                        Text(text = "Cancel")
                    }
                },
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.padding(16.dp)
            ) {
                DatePicker(
                    state = datePickerState,
                    dateFormatter = DatePickerFormatter()

                )
            }
        }
    }
}

