plugins {
	id("org.gradle.java-library")
	id("org.gradle.maven-publish")
}

group = "com.example"
version = "3.0"

publishing {
	publications {
		register<MavenPublication>("library") {
			from(project.components["java"])
		}
	}
	repositories {
		maven(rootProject.layout.buildDirectory.dir("maven")) { name = "local" }
	}
}

repositories {
	mavenCentral()
	google()
}

dependencies {
	compileOnly(gradleApi())
	compileOnly("com.android.tools.build:gradle:7.2.0")
}
