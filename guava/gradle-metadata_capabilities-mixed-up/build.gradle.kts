plugins {
	id("com.android.library") version "8.2.1"
}

dependencies {
	testImplementation("junit:junit:4.13.2")
	testImplementation("com.android.tools.layoutlib:layoutlib-api:31.2.1")
	testImplementation("com.google.guava:guava:33.0.0-jre")
}

android {
	namespace = "com.example"
	compileSdk = 34
	defaultConfig {
		minSdk = 14
	}
}

dependencies.constraints {
	testImplementation("com.google.guava:guava") {
		attributes {
			// Workaround from https://github.com/google/guava/issues/6801
			//attribute(
			//	TargetJvmEnvironment.TARGET_JVM_ENVIRONMENT_ATTRIBUTE,
			//	objects.named(TargetJvmEnvironment.STANDARD_JVM)
			//)
		}
	}
}

// Unrelated to repro, just gives more info on console.
tasks.withType<Test>().configureEach {
	testLogging {
		events = org.gradle.api.tasks.testing.logging.TestLogEvent.values().toSet()
		exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
		showExceptions = true
		showCauses = true
		showStackTraces = true
	}
}
