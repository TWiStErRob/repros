plugins {
	id("com.android.application") version "8.7.3"
}

android {
	compileSdk = 35
	defaultConfig {
		minSdk = 23
		targetSdk = 35

		namespace = "com.example.repro"
		versionCode = 1
		versionName = "1.0"
	}
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles("proguard-rules.pro")
        }
    }
}

repositories {
	google()
	mavenCentral()
}

dependencies {
	implementation("com.google.android.libraries.places:places:4.1.0")
	//implementation("androidx.lifecycle:lifecycle-viewmodel:2.8.7")
}
