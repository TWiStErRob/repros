https://github.com/gretty-gradle-plugin/gretty/issues/146

## Repro
```shell
gradlew :served:appRun
```
## Expected
no problem

## Actual
```
> Task :served:appRun
The configuration :lib:runtimeClasspath was resolved without accessing the project in a safe manner.  This may happen when a configuration is resolved from a thread not managed by Gradle or from a different project.  See https://docs.gradle.org/5.6.4/userguide/troubleshooting_dependency_resolution.html#sub:configuration_resolution_constraints for more details. This behaviour has been deprecated and is scheduled to be removed in Gradle 6.0.

01:01:46 WARN  Ignoring deprecated socket close linger time
01:01:51 INFO  Jetty 9.4.14.v20181114 started and listening on port 8080
01:01:51 INFO  served runs at:
01:01:51 INFO    http://localhost:8080/served

> Task :served:appRun
Press any key to stop the server.
```
