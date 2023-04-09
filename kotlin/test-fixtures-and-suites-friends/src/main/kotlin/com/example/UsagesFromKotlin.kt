package com.example

// Same source set, everything is good.
@Suppress("unused")
class UseMainFromKotlin {
	private val useJavaPublic = MainJavaPublic()
	private val useJavaInternal = MainJavaPackagePrivate()
	private val useKotlinPublic = MainKotlinPublic()
	private val useKotlinInternal = MainKotlinInternal()
}

// Production code never depends on tests.
//@Suppress("unused")
//class UseTestFromKotlin {
//	private val useJavaPublic = TestJavaPublic()
//	private val useJavaInternal = TestJavaPackagePrivate()
//	private val useKotlinPublic = TestKotlinPublic()
//	private val useKotlinInternal = TestKotlinInternal()
//}

// Production code never depends on test fixtures.
//@Suppress("unused")
//class UseTestFixturesFromKotlin {
//	private val useJavaPublic = TestFixturesJavaPublic()
//	private val useKotlinPublic = TestFixturesKotlinPublic()
//	private val useJavaInternal = TestFixturesJavaPackagePrivate()
//	private val useKotlinInternal = TestFixturesKotlinInternal()
//}

// Production code never depends on tests.
//@Suppress("unused")
//class UseIntegrationTestFromKotlin {
//	private val useJavaPublic = IntegrationTestJavaPublic()
//	private val useKotlinPublic = IntegrationTestKotlinPublic()
//	private val useJavaInternal = IntegrationTestJavaPackagePrivate()
//	private val useKotlinInternal = IntegrationTestKotlinInternal()
//}
