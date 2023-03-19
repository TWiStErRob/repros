package com.example;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import android.util.Log;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.isDialog;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;

public class MyActivityTest2 {

	@SuppressWarnings("deprecation")
	@Rule public final androidx.test.rule.ActivityTestRule<MyActivity> activity =
			new androidx.test.rule.ActivityTestRule<>(MyActivity.class);

	@Test
	public void test() {
		onView(isRoot()).inRoot(isDialog()).check(matches(isDisplayed()));
		for (int i = 0; i < 100; i++) {
			try {
				Log.wtf("Repro", "Iteration: " + i);
				Thread.sleep(100); // Only for observability in LogCat.
				onView(isRoot())
						.inRoot(isDialog())
						//.withFailureHandler((error, __) -> { throw (AssertionError)error; })
						.check(doesNotExist());
				fail("Expected to throw, because dialog is shown.");
			} catch (AssertionError expectedFailure) {
				String message = expectedFailure.getMessage();
				assertTrue(
						expectedFailure.toString(),
						message != null && message.startsWith("View is present in the hierarchy: DecorView{")
				);
			} catch (InterruptedException ignore) {
			}
		}
	}
}
