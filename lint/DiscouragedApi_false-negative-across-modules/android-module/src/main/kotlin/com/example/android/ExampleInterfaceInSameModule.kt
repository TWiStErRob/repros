package com.example.android

import androidx.annotation.Discouraged

@Discouraged("This should be flagged at usages.")
interface ExampleInterfaceInSameModule {
	fun myFun(): String
}
