plugins {
	id("com.android.library") version "8.1.2"
}

android {
	namespace = "com.example.lib"
	compileSdk = 34
	defaultConfig.minSdk = 21
	defaultConfig.targetSdk = 34 // TODO testOptions.targetSdk in AGP 8.2+.
	defaultConfig.testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
}

dependencies {
	// TODEL when androidx.monitor:1.7+ https://github.com/android/android-test/issues/1833
	//noinspection GradleDependency https://github.com/android/android-test/blob/83e58c9c52b41614b8bc3dd2bb4e6ccc23b86872/WORKSPACE#L11
	androidTestImplementation("org.jetbrains.kotlin:kotlin-stdlib:1.6.21")
	androidTestImplementation("androidx.test:runner:1.5.2")
	androidTestImplementation("androidx.test:rules:1.5.0")
}
