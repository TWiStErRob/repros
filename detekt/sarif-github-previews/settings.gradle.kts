pluginManagement {
	includeBuild("detekt/detekt-gradle-plugin")
}

plugins {
	id("io.gitlab.arturbosch.detekt") version "1.23.1" apply false
}

includeBuild("detekt") {
	dependencySubstitution {
		substitute(module("io.gitlab.arturbosch.detekt:detekt-cli"))
			.using(project(":detekt-cli"))
	}
}

dependencyResolutionManagement {
	repositories {
		mavenCentral()
	}
}

include(":subproject")

rootProject.name = "sarif-github-previews"
