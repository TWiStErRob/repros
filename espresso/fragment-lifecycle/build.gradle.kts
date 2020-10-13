plugins {
	id("com.android.application") version "4.0.1"
	kotlin("android") version "1.4.10"
}

repositories {
	google()
	jcenter()
}

dependencies {
	implementation("org.jetbrains.kotlin:kotlin-stdlib:1.4.10")
	implementation("androidx.appcompat:appcompat:1.2.0")

	debugImplementation("androidx.fragment:fragment-testing:1.3.0-beta01")

	androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")
	androidTestImplementation("androidx.test:runner:1.3.0")
	androidTestImplementation("androidx.test:rules:1.3.0")
	androidTestImplementation("androidx.test.ext:junit:1.1.2")
}

android {
	buildToolsVersion = "29.0.3"
	compileSdkVersion(29)
	defaultConfig {
		minSdkVersion(18)
		targetSdkVersion(29)
		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
	}

	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_1_8
		targetCompatibility = JavaVersion.VERSION_1_8
	}
	kotlinOptions {
		jvmTarget = JavaVersion.VERSION_1_8.toString()
	}
}
