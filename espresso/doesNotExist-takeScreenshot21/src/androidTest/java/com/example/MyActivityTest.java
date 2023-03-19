package com.example;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.matcher.RootMatchers.isDialog;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MyActivityTest {

	@SuppressWarnings("deprecation")
	@Rule public final androidx.test.rule.ActivityTestRule<MyActivity> activity =
			new androidx.test.rule.ActivityTestRule<>(MyActivity.class);

	@Test public void test01() { test(); }
	@Test public void test02() { test(); }
	@Test public void test03() { test(); }
	@Test public void test04() { test(); }
	@Test public void test05() { test(); }
	@Test public void test06() { test(); }
	@Test public void test07() { test(); }
	@Test public void test08() { test(); }
	@Test public void test09() { test(); }
	@Test public void test10() { test(); }
	@Test public void test11() { test(); }
	@Test public void test12() { test(); }
	@Test public void test13() { test(); }
	@Test public void test14() { test(); }
	@Test public void test15() { test(); }
	@Test public void test16() { test(); }
	@Test public void test17() { test(); }
	@Test public void test18() { test(); }
	@Test public void test19() { test(); }
	@Test public void test20() { test(); }
	@Test public void test21() { test(); }
	@Test public void test22() { test(); }
	@Test public void test23() { test(); }
	@Test public void test24() { test(); }
	@Test public void test25() { test(); }
	@Test public void test26() { test(); }
	@Test public void test27() { test(); }
	@Test public void test28() { test(); }
	@Test public void test29() { test(); }
	@Test public void test30() { test(); }
	@Test public void test31() { test(); }
	@Test public void test32() { test(); }

	private void test() {
		// Precondition: not necessary for repro.
		//onView(isRoot()).inRoot(isDialog()).check(matches(isDisplayed()));
		try {
			// Also would repro with: "no neutral button", because there's a neutral button.
			//onView(withId(android.R.id.button3)).inRoot(isDialog()).check(doesNotExist());
			// Really important for repro: doesNotExist()
			onView(isRoot()).inRoot(isDialog()).check(doesNotExist());
			fail("Expected to throw, because dialog is shown.");
		} catch(AssertionError expectedFailure) {
			String message = expectedFailure.getMessage();
			assertTrue(
					expectedFailure.toString(),
					message != null && message.startsWith("View is present in the hierarchy: DecorView{")
			);
		}
	}
}
