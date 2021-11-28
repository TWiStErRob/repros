https://github.com/gradle/gradle/issues/19143

Execute
 * `gradlew someOtherTask --scan`
 * `gradlew mustRunAfterThis someOtherTask --scan`

And compare task dependencies shown in the Build Scan timeline.
