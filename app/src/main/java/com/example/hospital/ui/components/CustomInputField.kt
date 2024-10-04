package com.example.hospital.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CustomInputField (
    modifier: Modifier = Modifier,
    leadingIcon: @Composable() (() -> Unit)? = null,
    value: String,
    onValueChange: (String) -> Unit,
    label :  @Composable() (() -> Unit)? = null,
    placeholder: String? = null,
    iconColor:  Color= Color.Gray,
    isError: Boolean = false,

    ) {
    OutlinedTextField(value = value, onValueChange = onValueChange,
        modifier = modifier.width(320.dp),
        shape = ShapeDefaults.Medium,
        label = label,
        isError = isError,
        leadingIcon = leadingIcon,
        placeholder = {
            if(placeholder != null)
                Text(text = placeholder)
        },
//        colors = TextFieldDefaults.colors(errorTextColor = Color.Red)
        )
}

@Preview(showSystemUi = true)
@Composable
fun Abc() {
    Column {
        CustomInputField(value = "", onValueChange = {},modifier = Modifier.fillMaxWidth(), iconColor = Color.Gray,
            placeholder = "Greet", isError = false
        )
    }
}