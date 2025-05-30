pluginManagement {
	repositories {
		google()
		mavenCentral()
	}
}

dependencyResolutionManagement {
	repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
	repositories {
		google()
		mavenCentral()
	}
}

include(":android-module")
include(":kotlin-module")
include(":retained-annotation")