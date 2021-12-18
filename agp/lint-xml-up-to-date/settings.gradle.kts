pluginManagement {
	repositories {
		gradlePluginPortal()
		google()
		mavenCentral()
	}
	resolutionStrategy {
		eachPlugin {
			if (requested.id.id.startsWith("com.android.")) {
				useModule("com.android.tools.build:gradle:${requested.version}")
			}
		}
	}
}

include(":app")
include(":lib")
