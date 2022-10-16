plugins {
    id("org.jetbrains.kotlin.jvm") version "1.7.20"
	id("io.gitlab.arturbosch.detekt") version "1.21.0"
}

repositories {
	mavenCentral()
}

detekt {
   config = files("detekt.yml")
}
