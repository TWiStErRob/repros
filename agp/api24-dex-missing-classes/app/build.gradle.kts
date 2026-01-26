plugins {
    id("com.android.application")
}

android {
    namespace = "com.example"
    compileSdk = 36

    defaultConfig {
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    androidTestImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test:runner:1.7.0")
    implementation(project(":library-with-classes"))
    androidTestImplementation(project(":library-with-classes"))
}

kotlin {
    jvmToolchain(17)
}
