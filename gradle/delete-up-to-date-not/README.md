https://github.com/gradle/gradle/issues/21856

## Repro
 1. clone this project
 2. run `gradlew generateContent`
 3. then `gradlew cleanContent --info`
 4. then `gradlew cleanContent --info` (sic)

## Observe
```
delete-up-to-date-not$ gradlew generateContent
BUILD SUCCESSFUL in 2s
1 actionable task: 1 executed

delete-up-to-date-not$ gradlew cleanContent --info
> Task :cleanContent
Caching disabled for task ':cleanContent' because:
  Build cache is disabled
Task ':cleanContent' is not up-to-date because:
  Task has not declared any outputs despite executing actions.
:cleanContent (Thread[included builds,5,main]) completed. Took 0.005 secs.

delete-up-to-date-not$ gradlew cleanContent --info
> Task :cleanContent UP-TO-DATE
Caching disabled for task ':cleanContent' because:
  Build cache is disabled
Task ':cleanContent' is not up-to-date because:
  Task has not declared any outputs despite executing actions.
:cleanContent (Thread[Execution worker Thread 17,5,main]) completed. Took 0.003 secs.
```

## Actual
First `:cleanContent` execution shows
```
> Task :cleanContent
Task ':cleanContent' is not up-to-date because:
```
which is a fair point, but the second execution is
```
> Task :cleanContent UP-TO-DATE
Task ':cleanContent' is not up-to-date because:
```
which is a clear WOT?! situation.

## Expected
Something non-contradictory.
