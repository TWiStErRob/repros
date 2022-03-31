plugins {
	id("com.android.application") version "4.2.2"
	id("org.jetbrains.kotlin.android") version "1.6.10"
}

dependencies {
	implementation("com.squareup.retrofit2:retrofit:2.9.0")
	implementation("com.squareup.retrofit2:converter-gson:2.9.0")
	implementation("com.squareup.okhttp3:logging-interceptor:4.9.3")
	implementation("io.reactivex.rxjava2:rxandroid:2.0.1")
	implementation("io.reactivex.rxjava2:rxjava:2.0.2")
	implementation("com.jakewharton.retrofit:retrofit2-rxjava2-adapter:1.0.0")
}

android {
	compileSdk = 31
	defaultConfig {
		minSdk = 14
		targetSdk = 31
	}
	buildTypes {
		named("debug") {
			// Normally this would be on release, but for simple repro using debug.
			isMinifyEnabled = true
		}
	}
}
