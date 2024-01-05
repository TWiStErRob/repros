package com.example

import io.mockk.every
import io.mockk.mockkObject
import org.junit.Test

class MyEnumTest {
	@Test fun test() {
		mockkObject(MyEnum.A)
		println(MyEnum.A)
		every { MyEnum.A.name } returns "not-a"
	}
}
