pluginManagement {
	repositories {
		gradlePluginPortal()
	}
}

dependencyResolutionManagement {
	repositories {
		mavenCentral()
	}
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

include(":other")
