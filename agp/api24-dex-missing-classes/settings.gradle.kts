rootProject.name = "repro"

include(":app")
include(":library-with-classes")
include(":library-standin")

dependencyResolutionManagement {
    repositoriesMode = RepositoriesMode.FAIL_ON_PROJECT_REPOS
    repositories {
        google()
        mavenCentral()
    }
}

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    plugins {
        id("com.android.application") version "9.0.0"
        id("org.jetbrains.kotlin.jvm") version "2.3.0"
    }
}
