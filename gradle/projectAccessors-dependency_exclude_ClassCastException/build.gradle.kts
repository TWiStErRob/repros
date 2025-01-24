plugins {
	id("org.gradle.java-library")
}

dependencies {
	implementation(projects.other) {
		libs.kotlin.stdlib.get().module.run { exclude(group, name) }
		providers
	}
}
