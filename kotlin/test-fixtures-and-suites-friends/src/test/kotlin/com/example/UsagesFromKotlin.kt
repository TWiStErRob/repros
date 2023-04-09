package com.example

// Standard setup by Kotlin Gradle Plugin, everything is good.
@Suppress("unused")
class UseMainFromKotlin {
	private val useJavaPublic = MainJavaPublic()
	private val useJavaInternal = MainJavaPackagePrivate()
	private val useKotlinPublic = MainKotlinPublic()
	private val useKotlinInternal = MainKotlinInternal()
}

// Same source set, everything is good.
@Suppress("unused")
class UseTestFromKotlin {
	private val useJavaPublic = TestJavaPublic()
	private val useJavaInternal = TestJavaPackagePrivate()
	private val useKotlinPublic = TestKotlinPublic()
	private val useKotlinInternal = TestKotlinInternal()
}

// Only visible when test is associated with testFixtures.
@Suppress("unused")
class UseTestFixturesFromKotlin {
	private val useJavaPublic = TestFixturesJavaPublic()
	private val useKotlinPublic = TestFixturesKotlinPublic()
	private val useJavaInternal = TestFixturesJavaPackagePrivate()
	private val useKotlinInternal = TestFixturesKotlinInternal() // RED
}

// Not visible, because test and integrationTest are siblings, no dependency or friend relationship.
//@Suppress("unused")
//class UseIntegrationTestFromKotlin {
//	private val useJavaPublic = IntegrationTestJavaPublic()
//	private val useKotlinPublic = IntegrationTestKotlinPublic()
//	private val useJavaInternal = IntegrationTestJavaPackagePrivate()
//	private val useKotlinInternal = IntegrationTestKotlinInternal()
//}
