plugins {
	id("com.android.application") version "7.3.1"
	kotlin("android") version "1.7.20"
	id("io.gitlab.arturbosch.detekt") version "1.22.0-RC2"
}

repositories {
	google()
	mavenCentral()
}

dependencies {
	implementation("org.jetbrains.kotlin:kotlin-stdlib")
	implementation("androidx.core:core-ktx:1.9.0")
}

android {
	namespace = "com.example"
	buildToolsVersion = "33.0.0"
	compileSdk = 33
	defaultConfig {
		minSdk = 21
		targetSdk = 33
		versionCode = 1
		versionName = "repro"
	}
}

detekt {
	debug = true
	buildUponDefaultConfig = true
	config = files("detekt.yml")
}
