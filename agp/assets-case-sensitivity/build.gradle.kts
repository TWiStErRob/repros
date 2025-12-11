plugins {
    id("com.android.application") version "8.13.1"
}

android {
    namespace = "com.example"
    compileSdk = 36
    defaultConfig.minSdk = 36
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}
