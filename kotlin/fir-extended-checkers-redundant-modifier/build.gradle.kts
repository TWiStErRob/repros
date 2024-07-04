plugins {
	id("org.jetbrains.kotlin.jvm") version "2.0.0"
}

kotlin {
    explicitApi()
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    compilerOptions {
        freeCompilerArgs.add("-Xuse-fir-extended-checkers")
    }
}
