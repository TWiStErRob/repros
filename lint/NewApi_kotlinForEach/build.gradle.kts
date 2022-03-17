plugins {
    id("com.android.application") version "4.1.3"
    id("org.jetbrains.kotlin.android") version "1.5.32"
}

android {
    buildToolsVersion = "30.0.3"
    compileSdkVersion(32)
    defaultConfig {
        applicationId = "com.repro"
        versionCode = 1
        versionName = "1.0"

        minSdkVersion(23)
        targetSdkVersion(32)
    }
    lintOptions {
        checkOnly("NewApi")
    }
}
