package com.example;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

import android.content.Context;

public class ExampleUnitTest {
	@Test
	public void mockSomeInterface() {
		// Need to mock too, because on JVM it's not usable directly.
		Context appContext = Mockito.mock();

		SomeInterface mock = Mockito.mock();
		Mockito.when(mock.doSomething(appContext)).thenReturn("Hello World");

		String result = new SomeClass(appContext, mock).doSomething();
		assertEquals("Hello World", result);
	}
}
