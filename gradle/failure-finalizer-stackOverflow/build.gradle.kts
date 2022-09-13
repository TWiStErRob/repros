plugins {
	id("com.android.application") version "7.1.2"
}

android {
	buildToolsVersion = "30.0.3"
	compileSdk = 32
	namespace = "com.example"
	defaultConfig {
		minSdk = 21
		targetSdk = 32
	}
}

afterEvaluate {
	tasks.named("preBuild").configure {
		doFirst { throw NullPointerException("simulating failure") }
	}
}
