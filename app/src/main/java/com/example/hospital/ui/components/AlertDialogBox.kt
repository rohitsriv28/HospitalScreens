package com.example.hospital.ui.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.DialogProperties


@Preview(showSystemUi = true)
@Composable
fun CustomAlert(
    openDialogBox : Boolean = false,
    text: String = "Alert",
    dismiss: () -> Unit = {},
    yes: () -> Unit = {},
    no: () -> Unit = {},
    dismissOutsideClick: Boolean = true,
    dismissOnBack: Boolean = true
) {

    if (openDialogBox) {
        AlertDialog(
            onDismissRequest = dismiss,
            title = {
                Text(text = text)
            },
            text = {
                Text(text = "Are you sure?")
            },
            confirmButton = {
                TextButton(onClick = yes) {
                    Text(text = "Yes")
                }
                TextButton(onClick = no) {
                    Text(text = "No")
                }
            },
            textContentColor = Color.Black,
            properties = DialogProperties(
                dismissOnBackPress = dismissOnBack ,
                dismissOnClickOutside = dismissOutsideClick
            )
        )
    }
}

