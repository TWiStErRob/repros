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

run { // Desugaring
	android.defaultConfig.multiDexEnabled = true
	android.compileOptions.isCoreLibraryDesugaringEnabled = true
	dependencies {
		coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:2.0.1")
	}
}

dependencies {
	androidTestImplementation("androidx.test:runner:1.5.2")
	// Ignore, workaround for https://github.com/android/android-test/issues/1672
	androidTestRuntimeOnly("org.jetbrains.kotlin:kotlin-stdlib:1.7.10")
}
