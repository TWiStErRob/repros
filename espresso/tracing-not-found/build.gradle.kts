plugins {
	id("com.android.application") version "7.3.1"
	kotlin("android") version "1.7.22"
}

dependencies {
	androidTestImplementation("androidx.test.espresso:espresso-core:3.5.0")
	androidTestImplementation("androidx.test.ext:junit:1.1.4")

	androidTestUtil("androidx.test:orchestrator:1.4.2")
}

android {
	namespace = "com.example"
	compileSdk = 33
	defaultConfig {
		minSdk = 21
		targetSdk = 33
		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
		testInstrumentationRunnerArguments["clearPackageData"] = "true"
	}
	testOptions {
		execution = "ANDROIDX_TEST_ORCHESTRATOR"
	}
}

// Make it fail: don't do this in production!
//configurations.all {
//	resolutionStrategy {
//		eachDependency {
//			if (requested.group == "androidx.test") {
//				when (requested.name) {
//					"annotation" -> useVersion("1.0.1")
//					"orchestrator" -> useVersion("1.4.2")
//					else -> useVersion("1.5.0")
//				}
//			}
//		}
//	}
//}
