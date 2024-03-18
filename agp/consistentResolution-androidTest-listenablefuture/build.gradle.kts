plugins {
	id("com.android.library") version "8.3.0"
}

android {
	namespace = "com.example"
	compileSdk = 34
	defaultConfig.minSdk = 14
}

dependencies {
	implementation("androidx.core:core:1.12.0")
	androidTestImplementation("androidx.test.espresso:espresso-contrib:3.5.1")
}
