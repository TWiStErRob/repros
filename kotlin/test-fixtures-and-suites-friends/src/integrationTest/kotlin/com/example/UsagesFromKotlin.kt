package com.example

// Only visible when integrationTest is associated with main.
@Suppress("unused")
class UseMainFromKotlin {
	private val useJavaPublic = MainJavaPublic()
	private val useJavaInternal = MainJavaPackagePrivate()
	private val useKotlinPublic = MainKotlinPublic()
	private val useKotlinInternal = MainKotlinInternal() // RED
}

// Not visible, because test and integrationTest are siblings, no dependency or friend relationship.
//@Suppress("unused")
//class UseTestFromKotlin {
//	private val useJavaPublic = TestJavaPublic()
//	private val useJavaInternal = TestJavaPackagePrivate()
//	private val useKotlinPublic = TestKotlinPublic()
//	private val useKotlinInternal = TestKotlinInternal()
//}

// Only visible when integrationTest depends on testFixtures().
@Suppress("unused")
class UseTestFixturesFromKotlin {
	private val useJavaPublic = TestFixturesJavaPublic()
	private val useKotlinPublic = TestFixturesKotlinPublic()
	private val useJavaInternal = TestFixturesJavaPackagePrivate()
	private val useKotlinInternal = TestFixturesKotlinInternal() // RED
}

// Same source set, everything is good.
@Suppress("unused")
class UseIntegrationTestFromKotlin {
	private val useJavaPublic = IntegrationTestJavaPublic()
	private val useKotlinPublic = IntegrationTestKotlinPublic()
	private val useJavaInternal = IntegrationTestJavaPackagePrivate()
	private val useKotlinInternal = IntegrationTestKotlinInternal()
}
