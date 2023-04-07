plugins {
	id("org.gradle.java")
}

testing.suites.named<JvmTestSuite>("test") {
	useJUnitJupiter("5.9.2")
}
