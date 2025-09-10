plugins {
	id("com.android.application") version "8.12.2" // relevant
	id("com.emergetools.android") version "4.4.0" // relevant
}

dependencies {
	runtimeOnly("com.emergetools.reaper:reaper:1.0.1") // relevant
}

android {
	namespace = "com.example"
	compileSdk = 36
	defaultConfig {
		minSdk = 36
		targetSdk = 36
	}
	testOptions {
		unitTests.isIncludeAndroidResources = true // relevant
	}
}

emerge {
	reaper {
		publishableApiKey = "invalid-token-to-have-non-empty-for-repro"
	}
}
