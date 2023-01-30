package com.example;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class ExampleInstrumentedTest {
	@Test
	public void mockSomeInterface() {
		// Use the real thing.
		Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

		SomeInterface mock = Mockito.mock();
		Mockito.when(mock.doSomething(appContext)).thenReturn("Hello World");

		String result = new SomeClass(appContext, mock).doSomething();
		assertEquals("Hello World", result);
	}
}
