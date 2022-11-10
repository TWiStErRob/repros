https://issuetracker.google.com/issues/258621112

## Expected
```
gradlew assemble -PagpVersion=8.0.0-alpha07
gradlew assemble -PagpVersion=8.0.0-alpha08
```
both compile.

## Actual
```
gradlew assemble -PagpVersion=8.0.0-alpha07
```
compiles, but `alpha08` doesn't.
