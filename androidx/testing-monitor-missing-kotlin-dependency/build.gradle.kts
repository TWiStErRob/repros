plugins {
	id("com.android.library") version "7.4.1"
}

android {
	namespace = "com.example.lib"
	compileSdk = 33
	defaultConfig {
		minSdk = 14
		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
	}
}

dependencies {
	androidTestImplementation("androidx.test:runner:1.5.2")
	//androidTestImplementation("org.jetbrains.kotlin:kotlin-stdlib:1.7.10")
}
