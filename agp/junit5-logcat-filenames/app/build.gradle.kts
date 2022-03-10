plugins {
	id("com.android.application")
}

android {
	buildToolsVersion = "30.0.3"
	compileSdk = 32
	defaultConfig {
		minSdk = 24
		targetSdk = 32
		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
		testInstrumentationRunnerArguments["runnerBuilder"] = "de.mannodermaus.junit5.AndroidJUnit5Builder"
	}
	packagingOptions {
		resources {
			excludes.add("META-INF/LICENSE.md")
			excludes.add("META-INF/LICENSE-notice.md")
		}
	}
}

dependencies {
	androidTestImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
	androidTestImplementation("de.mannodermaus.junit5:android-test-core:1.3.0") {
		// Exclude junit:junit, because all tests are using Jupiter.
		exclude(group = "junit", module = "junit")
	}
	androidTestImplementation("androidx.test:runner:1.4.0") {
		// Exclude junit:junit, because all tests are using Jupiter.
		exclude(group = "junit", module = "junit")
	}
	androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0") {
		// Exclude junit:junit, because all tests are using Jupiter.
		exclude(group = "junit", module = "junit")
	}
	androidTestRuntimeOnly("de.mannodermaus.junit5:android-test-runner:1.3.0")
}
