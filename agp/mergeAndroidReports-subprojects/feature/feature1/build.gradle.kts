plugins {
	id("com.android.library")
}

android {
	compileSdk = 32
	defaultConfig {
		minSdk = 21
		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
	}
}

dependencies {
	implementation(project(":base"))

	androidTestImplementation("androidx.test:rules:1.4.0")
	androidTestImplementation("androidx.test:runner:1.4.0")
	androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}
