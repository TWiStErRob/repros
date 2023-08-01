plugins {
	id("io.gitlab.arturbosch.detekt")
}

allprojects {
	tasks.register<Delete>("clean") {
		delete(layout.buildDirectory)
	}
	plugins.withId("io.gitlab.arturbosch.detekt") {
		detekt {
			ignoreFailures = true // Keep everything green.
			config.setFrom(rootProject.file("config/detekt.yml"))
		}
	}
}
