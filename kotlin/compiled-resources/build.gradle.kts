plugins {
	kotlin("jvm") version "1.7.10"
}

repositories {
	mavenCentral()
}

// Tried workaround: doesn't do anything.
//tasks.named<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>("compileTestKotlin") {
//	exclude("**/resources/**")
//}
