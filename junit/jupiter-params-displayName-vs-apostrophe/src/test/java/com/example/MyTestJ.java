package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SuppressWarnings("NewMethodNamingConvention")
@TestMethodOrder(MethodOrderer.MethodName.class)
public class MyTestJ {

	@BeforeEach
	public final void setUp(TestInfo info) {
		System.out.printf(
				"Class: %s, method: %s%nDisplay Name: %s%n%n",
				info.getTestClass().orElseThrow(),
				info.getTestMethod().orElseThrow(),
				info.getDisplayName()
		);
	}

	@MethodSource("methodSource")
	@ParameterizedTest
	public final void implicitName(String param) {
		assertNotNull(param);
	}

	@MethodSource("methodSource")
	@ParameterizedTest(name = "{0}")
	public final void zeroOnly(String param) {
		assertNotNull(param);
	}

	@MethodSource("methodSource")
	@ParameterizedTest(name = "{displayName}")
	public final void displayNameOnly(String param) {
		assertNotNull(param);
	}

	@MethodSource("methodSource")
	@ParameterizedTest(name = "{displayName} - {0}")
	public final void displayNameZero(String param) {
		assertNotNull(param);
	}

	@MethodSource("methodSource")
	@ParameterizedTest(name = "{0} - {displayName}")
	public final void zeroDisplayName(String param) {
		assertNotNull(param);
	}

	private static String[] methodSource() {
		return new String[] {
				"foo",
				"bar"
		};
	}
}
