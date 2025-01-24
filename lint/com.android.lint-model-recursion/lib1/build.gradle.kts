plugins {
	id("org.gradle.java-library")
	id("com.android.lint")
}

dependencies {
	api(project(":lib2"))
}
