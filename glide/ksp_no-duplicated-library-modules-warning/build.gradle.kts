plugins {
	id("com.android.library") version "8.1.2"
	id("org.jetbrains.kotlin.android") version "1.9.10"
	id("com.google.devtools.ksp") version "1.9.10-1.0.13"
}

android {
	namespace = "com.example.lib"
	compileSdk = 34
	defaultConfig.minSdk = 14
	compileOptions {
		sourceCompatibility = JavaVersion.current()
		targetCompatibility = JavaVersion.current()
	}
}

dependencies {
	val glideVersion = "4.16.0"
	implementation("com.github.bumptech.glide:glide:${glideVersion}")
	ksp("com.github.bumptech.glide:ksp:${glideVersion}")
}
