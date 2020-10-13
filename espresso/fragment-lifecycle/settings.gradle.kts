pluginManagement {
	repositories {
		gradlePluginPortal()
		google()
		jcenter()
	}
	resolutionStrategy {
		eachPlugin {
			if (requested.id.id.startsWith("com.android.")) {
				useModule("com.android.tools.build:gradle:${requested.version}")
			}
		}
	}
}
