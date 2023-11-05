plugins {
	id("org.gradle.java")
}

repositories {
	mavenCentral()
}

dependencies {
	implementation(libs.mockito.core)
	implementation(libs.mockito.android)
	implementation(libs.mockito.kotlin)
}
