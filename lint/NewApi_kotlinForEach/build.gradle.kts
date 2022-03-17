plugins {
    id("com.android.application") version "4.2.2"
    id("org.jetbrains.kotlin.android") version "1.6.10"
}

android {
    buildToolsVersion = "30.0.3"
    compileSdkVersion(31)
    defaultConfig {
        applicationId = "com.repro"
        versionCode = 1
        versionName = "1.0"

        minSdkVersion(23)
        targetSdkVersion(31)
    }
    lintOptions {
        checkOnly("NewApi")
    }
}
