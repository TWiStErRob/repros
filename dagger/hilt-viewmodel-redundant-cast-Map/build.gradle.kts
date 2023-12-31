plugins {
    id("com.android.application") version "8.2.0"
    id("com.google.dagger.hilt.android") version "2.50"
}

android {
    namespace = "com.example"
    compileSdk = 34
    defaultConfig {
        minSdk = 21
        targetSdk = 34
    }
    compileOptions {
        // Keep source-compatibilty low to avoid warnings on all the lambdas in the codebase.
        sourceCompatibility = JavaVersion.VERSION_1_7
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation("com.google.dagger:hilt-android:2.50")
    annotationProcessor("com.google.dagger:hilt-android-compiler:2.50")

    // Align Kotlin to prevent duplicate classes from stdlib.
    implementation(platform("org.jetbrains.kotlin:kotlin-bom:1.9.22"))
}

tasks.withType<JavaCompile>().configureEach {
    options.compilerArgs = options.compilerArgs + listOf(
        // Enable all warnings the compiler knows.
        "-Xlint:all",
        // No processor claimed any of these annotations:
        // dagger.hilt.android.HiltAndroidApp
        // android.annotation.*
        // androidx.annotation.*
        // net.twisterrob.*
        "-Xlint:-processing",
        // Fail build when any warning pops up.
        "-Werror",
        // warning: [options] source value 7 is obsolete and will be removed in a future release
        "-Xlint:-options",
    )
}
