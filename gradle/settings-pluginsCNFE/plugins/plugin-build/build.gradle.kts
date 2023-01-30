plugins {
	id("org.gradle.java-gradle-plugin")
	id("org.gradle.maven-publish")
}

group = "com.example"
version = "2.0"

gradlePlugin {
	plugins {
		create("build") {
			id = "com.example.build"
			implementationClass = "com.example.BuildPlugin"
		}
	}
}

publishing {
	repositories {
		maven(rootProject.layout.buildDirectory.dir("maven")) { name = "local" }
	}
}

repositories {
	mavenCentral()
	google()
}

dependencies {
	compileOnly("com.android.tools.build:gradle:7.2.0")
	implementation(project(":shared-lib"))
}
