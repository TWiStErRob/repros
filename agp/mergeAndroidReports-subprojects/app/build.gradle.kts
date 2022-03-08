plugins {
	id("com.android.application")
}

dependencies {
	implementation(project(":feature:feature1"))
	implementation(project(":feature:feature2"))
}

android {
	buildToolsVersion = "30.0.3"
	compileSdk = 32
	defaultConfig {
		minSdk = 21
		targetSdk = 32
		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
	}
}

dependencies {
	androidTestImplementation("androidx.test:rules:1.4.0")
	androidTestImplementation("androidx.test:runner:1.4.0")
	androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}
