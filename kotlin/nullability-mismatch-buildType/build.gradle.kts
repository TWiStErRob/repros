import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

plugins {
	id("org.jetbrains.kotlin.jvm") version "2.2.20"
}

repositories {
	mavenCentral()
	google()
}

dependencies {
	implementation(gradleApi())
	implementation("com.android.tools.build:gradle:8.11.2") // relevant
}

kotlin {
	compilerOptions {
		languageVersion = KotlinVersion.KOTLIN_1_9 // relevant
		// Not relevant, just helps to see better.
		freeCompilerArgs.add("-Xrender-internal-diagnostic-names")
	}
}
