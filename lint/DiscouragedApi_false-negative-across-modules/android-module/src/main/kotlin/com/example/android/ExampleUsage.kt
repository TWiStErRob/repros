package com.example.android

import com.example.kotlin.ExampleInterfaceInOtherModule

class ExampleUsage(
	private val exampleOther: ExampleInterfaceInOtherModule,
	private val exampleSame: ExampleInterfaceInSameModule,
) {
	fun myFun(): String {
		return listOf(
			exampleSame.myFun(),
			exampleOther.myFun(),
		).joinToString()
	}
}
