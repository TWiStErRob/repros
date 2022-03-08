include(":app")
include(":base")
include(":feature:feature1")
include(":feature:feature2")

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
