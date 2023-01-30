pluginManagement {
	repositories {
		mavenCentral()
		google()
		maven("plugins/build/maven") { name = "local plugins" }
		gradlePluginPortal()
	}
}

plugins {
	id("com.example.settings") version "1.0"
}

gradle.settingsEvaluated { 
	settings.buildscript.configurations.getByName("classpath").run {
		dependencies.forEach { println(it) }
		files.forEach { println(it) }
	}
}
