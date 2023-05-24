plugins {
    id("org.jetbrains.kotlin.jvm") version "1.8.20"
    id("org.jetbrains.kotlin.kapt") version "1.8.20"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")

    implementation("com.google.dagger:dagger:2.46.1")
    kapt("com.google.dagger:dagger-compiler:2.46.1")
}
