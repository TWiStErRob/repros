package com.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BaseTest {
	@Test public void baseTest() {
		assertEquals("base", new Base().toString());
	}
}
