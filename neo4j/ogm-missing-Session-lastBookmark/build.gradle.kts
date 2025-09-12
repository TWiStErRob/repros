plugins {
	id("org.jetbrains.kotlin.jvm") version "2.2.20"
	id("org.gradle.application")
}

application {
	mainClass = "com.example.AppKt"
}

kotlin {
	jvmToolchain(21)
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.neo4j:neo4j-ogm-core:4.0.20")
	implementation("org.neo4j:neo4j-ogm-bolt-driver:4.0.20")

	//implementation("org.neo4j.test:neo4j-harness:2025.07.1") // works
	//implementation("org.neo4j.test:neo4j-harness:2025.08.0") // fails
	implementation("org.neo4j.test:neo4j-harness:2025.08.0")
}
