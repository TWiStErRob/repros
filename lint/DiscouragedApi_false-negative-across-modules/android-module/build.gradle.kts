plugins {
	id("com.android.library")
	id("org.jetbrains.kotlin.android")
}

dependencies {
	implementation(project(":kotlin-module"))
	if (project.hasProperty("repro.with.fix").toString().toBooleanStrict()) {
		implementation(project(":retained-annotation"))
	} else {
		implementation("androidx.annotation:annotation:1.9.0")
	}
}

android {
	namespace = "com.repro.android"
	compileSdk = 35
	lint {
		checkOnly += "DiscouragedApi"
	}
}

kotlin {
	jvmToolchain(17)
}
