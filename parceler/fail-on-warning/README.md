https://github.com/johncarl81/parceler/issues/381

## Repro
```shell
gradlew assembleDebug
```

Without `addStandardOutputListener` this project compiles fine with a warning.
