https://github.com/android/android-test/issues/1794

See [Test class](src/androidTest/java/com/example/AnnotationFilterTest.java) for test setup.

Note:
```shell
$ ./gradlew connectedCheck "-Pandroid.testInstrumentationRunnerArguments.annotation=name"
```
is equivalent to
```shell
$ adb shell am instrument ... -e annotation name
```

### No annotations
```shell
$ ./gradlew connectedCheck

> Task :connectedDebugAndroidTest
Starting 5 tests on Pixel_XL_API_33(AVD) - 13
```

```shell
$ ./gradlew connectedCheck "-Pandroid.testInstrumentationRunnerArguments.annotation="

> Task :connectedDebugAndroidTest
Starting 5 tests on Pixel_XL_API_33(AVD) - 13
```

### One annotation
```shell
$ ./gradlew connectedCheck "-Pandroid.testInstrumentationRunnerArguments.annotation=com.example.MyAnnotation1"

> Task :connectedDebugAndroidTest
Starting 3 tests on Pixel_XL_API_33(AVD) - 13
```

```shell
$ ./gradlew connectedCheck "-Pandroid.testInstrumentationRunnerArguments.annotation=com.example.MyAnnotation2"

> Task :connectedDebugAndroidTest
Starting 3 tests on Pixel_XL_API_33(AVD) - 13
```

### Intersection of annotations
```shell
$ ./gradlew connectedCheck "-Pandroid.testInstrumentationRunnerArguments.annotation=com.example.MyAnnotation1,com.example.MyAnnotation2"

> Task :connectedDebugAndroidTest
Starting 2 tests on Pixel_XL_API_33(AVD) - 13
```

### One annotation with non-existent annotation
Runs tests with `MyAnnotation1`, `MyAnnotation3` is just ignored.
```shell
$ ./gradlew connectedCheck "-Pandroid.testInstrumentationRunnerArguments.annotation=com.example.MyAnnotation1,com.example.MyAnnotation3"

> Task :connectedDebugAndroidTest
Starting 3 tests on Pixel_XL_API_33(AVD) - 13
```

### Non-existent annotation only
Runs all tests, no visible warning in Gradle output.

```shell
$ ./gradlew connectedCheck "-Pandroid.testInstrumentationRunnerArguments.annotation=com.example.MyAnnotation3"

> Task :connectedDebugAndroidTest
Starting 5 tests on Pixel_XL_API_33(AVD) - 13
```

```shell
$ ./gradlew connectedCheck "-Pandroid.testInstrumentationRunnerArguments.annotation=com.example.MyAnnotation3,com.example.MyAnnotation4"

> Task :connectedDebugAndroidTest
Starting 5 tests on Pixel_XL_API_33(AVD) - 13
```
