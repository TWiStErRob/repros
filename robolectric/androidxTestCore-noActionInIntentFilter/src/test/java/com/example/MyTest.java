package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowLog;

@RunWith(RobolectricTestRunner.class)
@Config(shadows = ShadowLog.class)
public class MyTest {

	@Before
	public void setUp() {
		ShadowLog.stream = System.out;
	}

	@Test
	public void test1() {
		System.out.println("test 1");
	}

	// The output will only be generated between tests, not at first test.

	@Test
	public void test2() {
		System.out.println("test 2");
	}
}
