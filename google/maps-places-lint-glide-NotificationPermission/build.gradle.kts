plugins {
	id("com.android.application") version "8.13.0"
}

android {
	compileSdk = 36
	defaultConfig {
		minSdk = 24
		targetSdk = 36

		namespace = "com.example.repro"
		versionCode = 1
		versionName = "1.0"
	}
	lint {
		// For reproducibility, even without this line the problem occurs with default config.
		checkOnly.add("NotificationPermission")
	}
}

dependencies {
	implementation("com.google.android.libraries.places:places:5.0.0")
}
