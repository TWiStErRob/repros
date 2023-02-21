plugins {
	id("org.jetbrains.kotlin.jvm") version "1.8.10"
	id("io.gitlab.arturbosch.detekt") version "1.22.0"
}

repositories {
	mavenCentral()
}

detekt {
	dependencies {
		detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.22.0")
	}
}
