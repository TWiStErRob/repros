plugins {
	id("com.android.library") version "8.4.0"
	id("org.jetbrains.kotlin.android") version "1.9.24"
}

android {
	namespace = "com.example"
	compileSdk = 34
	defaultConfig.targetSdk = 34
	defaultConfig.minSdk = 34
	buildFeatures.compose = true
	composeOptions.kotlinCompilerExtensionVersion = "1.5.14"
	testOptions.unitTests.isIncludeAndroidResources = true
	defaultConfig.testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
	if (project.findProperty("run_as_ui").toString().toBoolean()) {
		sourceSets.named("androidTest") { kotlin.srcDir("src/test/kotlin") }
	}
}

kotlin {
	jvmToolchain(17)
}

dependencies {
	implementation(platform("androidx.compose:compose-bom:2024.05.00"))
	implementation("androidx.compose.material3:material3")
	implementation("androidx.compose.ui:ui-tooling-preview")

	debugImplementation("androidx.compose.ui:ui-tooling")
	debugImplementation("androidx.compose.ui:ui-test-manifest")
	testImplementation(platform("androidx.compose:compose-bom:2024.05.00"))
	testImplementation("androidx.compose.ui:ui-test-junit4")
	testRuntimeOnly("org.robolectric:robolectric:4.12.1")

	androidTestImplementation(platform("androidx.compose:compose-bom:2024.05.00"))
	androidTestImplementation("androidx.compose.ui:ui-test-junit4")
}
