plugins {
	id("com.android.application") version "8.3.0"
}

android {
	namespace = "com.example"
	compileSdk = 34
	defaultConfig.minSdk = 21
	buildTypes { release { isMinifyEnabled = true } }
}

dependencies {
	implementation("com.google.android.libraries.places:places:3.4.0")
}
