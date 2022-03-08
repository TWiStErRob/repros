package com.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Feature1Test {
	@Test public void f1Test() {
		assertEquals("base", new Base().toString());
		assertEquals("f1", new Feature1().toString());
	}
}
