https://github.com/gradle/gradle/issues/21101

Related: https://github.com/gradle/gradle/issues/16593

Repro:
 1. clone this project
 2. run `gradlew :dependencies --write-locks`

Observe: `settings-gradle.lockfile` with contents `empty=incomingCatalogForLibs0`.

Expected: this `incomingCatalogForLibs0` to be in `gradle/dependency-locks/settings.lockfile` as configured.
