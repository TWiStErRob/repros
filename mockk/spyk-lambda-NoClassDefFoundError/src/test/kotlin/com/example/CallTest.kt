package com.example

import io.mockk.spyk
import io.mockk.verify
import org.junit.Test

class CallTest {
	@Test fun test() {
		val callback = spyk({})

		call(callback)

		verify { callback() }
	}
}
