plugins {
	id("com.android.library") version "8.4.0"
	id("org.jetbrains.kotlin.android") version "1.9.23"
}

android {
	namespace = "com.example"
	compileSdk = 34
	defaultConfig.minSdk = 14
	buildFeatures {
		compose = true
	}
	composeOptions {
		kotlinCompilerExtensionVersion = "1.5.13"
	}
}

dependencies {
	implementation(platform("androidx.compose:compose-bom:2024.05.00"))
	implementation("androidx.compose.ui:ui")
	implementation("androidx.compose.material3:material3")
}

kotlin {
	jvmToolchain(17)
}
