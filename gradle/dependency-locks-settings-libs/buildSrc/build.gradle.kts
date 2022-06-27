plugins {
	`kotlin-dsl`
}

repositories {
	mavenCentral()
}

dependencyLocking {
	lockAllConfigurations()
	lockMode.set(LockMode.LENIENT)
	lockFile.set(rootProject.file("../gradle/dependency-locks/buildSrc.lockfile"))
}
