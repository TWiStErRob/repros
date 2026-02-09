repositories {
	mavenCentral()
	// Only released versions (not snapshots) from private repo.
	exclusiveContent {
		forRepository {
			maven("https://private.repo/packages")
		}
		filter {
			includeVersionByRegex("com\\.myorg.*", ".+", "^(.(?!-SNAPSHOT))+$")
		}
	}
	// Snapshots from local maven cache.
	exclusiveContent {
		forRepository {
			mavenLocal()
		}
		filter {
			includeVersionByRegex("com\\.myorg.*", ".+", ".+-SNAPSHOT")
		}
	}
}

dependencies {
	implementation("junit:junit:4.13.2")
}
