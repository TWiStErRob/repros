package com.example

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun TimePickerDialog(
	onCancel: () -> Unit = {},
) {
	DatePickerDialog(
		confirmButton = {},
		onDismissRequest = {},
		dismissButton = { TextButton(onCancel) { Text("Cancel") } }
	) {
		CompositionLocalProvider(
			LocalTextStyle provides LocalTextStyle.current.merge(
				other = MaterialTheme.typography.labelLarge
			)
		) {
			Text(text = "Select time", modifier = Modifier.padding(15.dp))
		}
		TimePicker(rememberTimePickerState())
	}
}

@Preview
@Composable
private fun TimePickerDialogPreview() {
	TimePickerDialog()
}
