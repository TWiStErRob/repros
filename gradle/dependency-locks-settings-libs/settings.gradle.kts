buildscript {
	dependencyLocking {
		lockAllConfigurations()
		lockMode.set(LockMode.STRICT)
		lockFile.set(file("gradle/dependency-locks/settings.lockfile"))
	}
}
