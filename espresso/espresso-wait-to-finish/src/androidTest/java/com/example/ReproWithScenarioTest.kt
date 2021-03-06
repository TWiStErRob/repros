package com.example

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ReproWithScenarioTest {

	@get:Rule
	val activityRule = ActivityScenarioRule(Activity1::class.java)

	@Test fun test() {
		onView(withId(R.id.button1)).perform(click())
		// replacing button2.click with `activityRule.scenario.onActivity { it.finish() }` fails,
		// because it closes the first activity currently in the background
		onView(withId(R.id.button2)).perform(click())
		onView(withId(R.id.button1)).check(matches(isCompletelyDisplayed()))
	}
}
