plugins {
	id("org.jetbrains.kotlin.jvm") version "2.3.0"
	id("org.gradle.application")
}

kotlin {
	jvmToolchain(21)
	compilerOptions {
		allWarningsAsErrors = true
	}
}

application {
	mainClass = "com.example.AppKt"
}

tasks.named<JavaExec>("run").configure {
	// Only 3.2.0 Gradle Plugin supports this.
	// Plugin is not used here, but functionality "backported".
	systemProperty(
		"io.ktor.development",
		project
			.providers
			.gradleProperty("io.ktor.development")
			.getOrElse("false")
			.toBoolean()
	)
}

dependencies {
	val ktor = "3.2.0"
	implementation("org.jetbrains.kotlin:kotlin-stdlib")
	implementation("io.ktor:ktor-server-call-logging:${ktor}")
	implementation("io.ktor:ktor-server-cors:${ktor}")
	implementation("io.ktor:ktor-server-netty:${ktor}")
	implementation("io.ktor:ktor-server-status-pages:${ktor}")
	runtimeOnly("org.slf4j:slf4j-simple:2.0.17")
}
