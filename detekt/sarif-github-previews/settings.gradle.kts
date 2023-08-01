plugins {
	id("io.gitlab.arturbosch.detekt") version "1.23.1" apply false
}

dependencyResolutionManagement {
	repositories {
		mavenCentral()
	}
}

include(":subproject")

rootProject.name = "sarif-github-previews"
