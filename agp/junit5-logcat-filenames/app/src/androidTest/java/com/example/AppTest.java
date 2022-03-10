package com.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest {

	static class Scenario {
		final String useCase;
		final String input;
		final String expected;
		Scenario(String useCase, String input, String expected) {
			this.useCase = useCase;
			this.input = input;
			this.expected = expected;
		}
	}
	
	@Test void simple() {
		assertTrue(true);
	}

	@TestFactory List<DynamicTest> appToString() {
		List<Scenario> scenarios = Arrays.asList(
				new Scenario(
						"Appends a",
						"a",
						"app a"
				),
				new Scenario(
						"Appends empty",
						"",
						"app "
				),
				new Scenario(
						"Appends null",
						null,
						"app null"
				)
		);
		return scenarios
				.stream()
				.map(it ->
						DynamicTest.dynamicTest(it.useCase, () -> {
							App sut = new App(it.input);

							String result = sut.toString();

							assertEquals(it.expected, result);
						}))
				.collect(Collectors.toList());
	}
}
