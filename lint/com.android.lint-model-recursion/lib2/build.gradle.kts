plugins {
	id("org.gradle.java-library")
	id("com.android.lint")
}

dependencies {
	// This library is part of lib1, not designed to work on its own.
	// When referenced directly, add parent to the classpath so the context is available.
	runtimeOnly(project(":lib1"))
}
