package com.example

// Standard setup by Kotlin Gradle Plugin, everything is good.
@Suppress("unused")
class UseMainFromKotlin {
	private val useJavaPublic = MainJavaPublic()
	private val useJavaInternal = MainJavaPackagePrivate()
	private val useKotlinPublic = MainKotlinPublic()
	private val useKotlinInternal = MainKotlinInternal()
}

// Test Fixtures don't see tests, they provide utilities for tests.
//@Suppress("unused")
//class UseTestFromKotlin {
//	private val useJavaPublic = TestJavaPublic()
//	private val useJavaInternal = TestJavaPackagePrivate()
//	private val useKotlinPublic = TestKotlinPublic()
//	private val useKotlinInternal = TestKotlinInternal()
//}

// Same source set, everything is good.
@Suppress("unused")
class UseTestFixturesFromKotlin {
	private val useJavaPublic = TestFixturesJavaPublic()
	private val useKotlinPublic = TestFixturesKotlinPublic()
	private val useJavaInternal = TestFixturesJavaPackagePrivate()
	private val useKotlinInternal = TestFixturesKotlinInternal()
}

// Test Fixtures don't see tests, they provide utilities for tests.
//@Suppress("unused")
//class UseIntegrationTestFromKotlin {
//	private val useJavaPublic = IntegrationTestJavaPublic()
//	private val useKotlinPublic = IntegrationTestKotlinPublic()
//	private val useJavaInternal = IntegrationTestJavaPackagePrivate()
//	private val useKotlinInternal = IntegrationTestKotlinInternal()
//}
