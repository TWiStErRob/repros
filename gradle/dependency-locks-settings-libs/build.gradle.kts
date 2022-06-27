plugins {
	java
}

dependencyLocking {
	lockAllConfigurations()
	lockMode.set(LockMode.STRICT)
	lockFile.set(rootProject.file("gradle/dependency-locks/rootProject.lockfile"))
}
