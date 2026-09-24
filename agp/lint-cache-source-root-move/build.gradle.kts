plugins {
    id("com.android.library") version "9.4.1"
}

android {
    namespace = "com.example"
    compileSdk = 36

    defaultConfig {
        minSdk = 23
    }

    lint {
        checkOnly += "UseKtx"
        warningsAsErrors = true
        baseline = file("lint-baseline.xml")
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.17.0")
}
