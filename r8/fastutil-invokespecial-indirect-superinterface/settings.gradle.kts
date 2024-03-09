pluginManagement {
	repositories {
		gradlePluginPortal()
	}
}

plugins {
	id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
	repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
	repositories {
		mavenCentral()
		exclusiveContent { 
			forRepository { 
				google()
			}
			filter {
				includeModule("com.android.tools", "r8")
			}
		}
	}
}
