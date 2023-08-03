@file:Suppress("UnusedImport")

package com.example

import com.example.assertThat
import com.thirdparty.Assert.assertThat

fun repro(other: String, specificType: SpecificType) {
	assertThat(other).genericMethod()
	assertThat(specificType).specialMethod()
}
