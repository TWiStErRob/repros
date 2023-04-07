plugins {
	id("org.gradle.java")
	id("org.jetbrains.kotlin.jvm") version "1.8.20"
}

testing.suites.named<JvmTestSuite>("test") {
	useJUnitJupiter("5.9.2")
}
