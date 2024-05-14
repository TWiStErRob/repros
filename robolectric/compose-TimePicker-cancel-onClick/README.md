Repro:
1. Clone https://github.com/TWiStErRob/repros/tree/main/compose/lint-ModifierFactoryUnreferencedReceiver-composed-this
2. Run `./gradlew :test` and observe the test failure
3. Run `./gradlew :connectedCheck` and observe the test success (emulator 34!)

**Expected behavior**: `./gradlew :test` should pass too, same trivial test code.

**Actual behavior**: all I know is that `performClick()` apparently executes on "Cancel" button,
but the `onClick` lambda is not called on Robolectric.

Weird things:
 * Removing `TimePicker()` makes it work
 * Removing `padding(24.dp)` makes it work
 * Reducing `padding(15.dp)` to anything less than 15 makes it work
 * Removing one of the `provides` lines makes it work
 * Changing the title text from `"Select time"` to `""` makes it work
 * Changing `DatePickerDialog` to `AlertDialog` with `text = { ... }` makes it work
 * Changing from `TextButton` to `Text(modifier = clickable(onCancel)` still fails
