@file:Suppress("detekt.MaxLineLength")

package com.example

import com.goncalossilva.resources.Resource
import kotlin.test.Test
import kotlin.test.assertEquals

class LengthKtTest {

	@Test
	fun testHardcoded() {
		assertEquals(3, length("123"))
	}

	@Test
	fun testResource() {
		val actual = length(Resource("some-file.txt").readText())

		assertEquals(5 + 1, actual)
	}
}
