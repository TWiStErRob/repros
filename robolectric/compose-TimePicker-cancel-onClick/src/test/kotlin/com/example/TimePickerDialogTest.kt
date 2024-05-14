package com.example

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TimePickerDialogTest {
	@get:Rule
	val compose = createComposeRule()

	@Test fun test() {
		var called = false
		compose.setContent {
			TimePickerDialog(onCancel = { called = true })
		}

		compose.onNodeWithText("Cancel").performClick()

		assertTrue(called)
	}
}
