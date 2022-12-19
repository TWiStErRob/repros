package com.example

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MyActivityTest {

	@Test fun test() {
		ActivityScenario.launch(MyActivity::class.java).use { scenario ->
			scenario.moveToState(Lifecycle.State.RESUMED)
			onView(withId(android.R.id.content)).perform(click())
		}
	}
}
