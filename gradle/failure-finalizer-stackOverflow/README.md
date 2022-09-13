https://github.com/gradle/gradle/issues/21997

Repro:
 * Clone this project
 * Run `gradlew assembleDebug`

Observe: 
```
2: Task failed with an exception.
-----------
* What went wrong:
java.lang.StackOverflowError (no error message)

* Exception is:
java.lang.StackOverflowError
        at org.gradle.execution.plan.Node.isCanCancel(Node.java:232)
        at org.gradle.execution.plan.FinalizerGroup.isCanCancel(FinalizerGroup.java:155)
        at org.gradle.execution.plan.CompositeNodeGroup.isCanCancel(CompositeNodeGroup.java:101)
        at org.gradle.execution.plan.Node.isCanCancel(Node.java:232)
        ...
```

Note:
 * Changing `gradle\wrapper\gradle-wrapper.properties` to 7.5 doesn't show the `StackOverflowError`
 * Running only `gradlew preBuild` doesn't show the `StackOverflowError`

Related? https://github.com/gradle/gradle/issues/21975
