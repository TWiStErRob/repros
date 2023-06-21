plugins {
	id("com.android.library") version "8.0.1"
}

android {
	namespace = "com.example"
	compileSdk = 33
	defaultConfig.targetSdk = 33
	defaultConfig.minSdk = 33
	testOptions.unitTests.isIncludeAndroidResources = true
}

dependencies {
	// This looks silly, but androidx.fragment:fragment-testing transitively depends on it, so it comes up IRL.
	implementation("androidx.test:core:1.5.0")
	testImplementation("junit:junit:4.13.2")
	testImplementation("org.robolectric:robolectric:4.10.2")
}
