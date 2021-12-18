plugins {
	id("com.android.application")
}

repositories {
	google()
	mavenCentral()
}

dependencies {
	implementation(project(":lib"))
}

android {
	buildToolsVersion = "30.0.3"
	compileSdk = 32
	defaultConfig {
		minSdk = 21
		targetSdk = 32
	}
}
