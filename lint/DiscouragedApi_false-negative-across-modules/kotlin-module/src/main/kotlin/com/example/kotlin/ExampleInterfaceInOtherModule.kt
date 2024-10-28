package com.example.kotlin

import androidx.annotation.Discouraged

@Discouraged("This should be flagged at usages in other modules.")
interface ExampleInterfaceInOtherModule {
	fun myFun(): String
}
