package com.example

interface SpecificType

interface SpecificFluentAssertion {
	fun specialMethod()
}

fun assertThat(actual: SpecificType): SpecificFluentAssertion =
	TODO("Problem is compiler only. Using ${actual} to satisfy unused parameter check.")
