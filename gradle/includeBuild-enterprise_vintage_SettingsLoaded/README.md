https://github.com/gradle/gradle/issues/22521

Preconditions:
 * `including$ gradlew` to validate `including` project works on its own
 * `included$ gradlew` to validate `included` project works on its own

Repro: `including$ gradlew --include-build ../included --no-daemon`

Note: adding `includeBuild("../included")` in `including/settings.gradle.kts` has the same effect.
