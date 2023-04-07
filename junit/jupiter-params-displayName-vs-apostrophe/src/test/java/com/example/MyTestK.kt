package com.example

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.TestInfo
import org.junit.jupiter.api.TestMethodOrder
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

@TestMethodOrder(MethodOrderer.MethodName::class)
class MyTestK {

	@BeforeEach
	fun setUp(info: TestInfo) {
		System.out.printf(
			"Class: %s, method: %s%nDisplay Name: %s%n%n",
			info.testClass.orElseThrow(),
			info.testMethod.orElseThrow(),
			info.displayName
		)
	}

	@MethodSource("methodSource")
	@ParameterizedTest
	fun implicitName(param: String) {
		Assertions.assertNotNull(param)
	}

	@MethodSource("methodSource")
	@ParameterizedTest(name = "{0}")
	fun zeroOnly(param: String) {
		Assertions.assertNotNull(param)
	}

	@MethodSource("methodSource")
	@ParameterizedTest(name = "{displayName}")
	fun displayNameOnly(param: String) {
		Assertions.assertNotNull(param)
	}

	@MethodSource("methodSource")
	@ParameterizedTest(name = "{displayName} - {0}")
	fun displayNameZero(param: String) {
		Assertions.assertNotNull(param)
	}

	@MethodSource("methodSource")
	@ParameterizedTest(name = "{0} - {displayName}")
	fun zeroDisplayName(param: String) {
		Assertions.assertNotNull(param)
	}

	companion object {

		@JvmStatic
		private fun methodSource(): Array<String> =
			arrayOf(
				"foo",
				"bar"
			)
	}
}
