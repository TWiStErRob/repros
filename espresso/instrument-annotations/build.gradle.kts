plugins {
	id("com.android.application") version "8.0.1"
}

dependencies {
	androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
	androidTestImplementation("androidx.test:runner:1.5.2")
	androidTestImplementation("androidx.test:rules:1.5.0")
	androidTestImplementation("androidx.test.ext:junit:1.1.5")
}

android {
	namespace = "com.example"
	compileSdk = 33
	defaultConfig {
		minSdk = 24
		targetSdk = 33
		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
	}
}
