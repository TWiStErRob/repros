package com.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Feature2Test {
	@Test public void f2Test() {
		assertEquals("base", new Base().toString());
		assertEquals("f2", new Feature2().toString());
	}
}
