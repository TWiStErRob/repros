plugins {
	id("com.android.library") version "8.6.0"
	id("org.jetbrains.kotlin.android") version "2.0.20"
}

android {
	namespace = "com.example.lib"
	compileSdk = 34
	defaultConfig.minSdk = 14
}

kotlin {
	jvmToolchain(8)
}

dependencies {
	testImplementation("junit:junit:4.13.2")
}
