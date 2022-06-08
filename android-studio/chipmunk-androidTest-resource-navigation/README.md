https://issuetracker.google.com/issues/235374639

Android Studio: Good code red and cannot navigate from androidTest sourceSet (with easy repro)

The repro project is fully compilable and executable.
You can run `Repro.test()` as an instrumentation test.

Navigation in `androidTest` source set is completely broken when using modules.
This means that it's not possible to navigate to the definition of an id or a string resource with a Cmd/Ctrl+Click.
This also means the IDE functionality is degraded to that of a grep tool when working with UI tests.

Repro:
 * Clone https://github.com/TWiStErRob/repros/tree/master/android-studio/chipmunk-androidTest-resource-navigation
 * Import in Android Studio Chipmunk 7.2.1
 * Observe build.gradle has AGP 4.2.2
 * Open Repro.kt
 * Observe what's described in comments or attached in screenshots.
 * Edit build.gradle to AGP 7.2.1
 * Sync
 * Open Repro.kt
 * Observe what's described in comments or attached in screenshots.

I tried multiple AGP versions by changing the root build.gradle and syncing.
Android Gradle Plugin 4.2.2, 7.0.3, 7.1.2, 7.2.1.
Note that 3.2 is listed as lowest compatible at https://developer.android.com/studio/releases#agp-studio-compatibility.

Note that the Kotlin import aliasing does not (and should not) change the problem.
We used that to demonstrate all the different R usages in one file.

As a double-check see Verify.kt where everything works as expected.
(Obviously, androidTest/res cannot be tested there...)

---

Reproduced on fresh install of Android Studio Chipmunk 7.2.1
```
Android Studio Chipmunk | 2021.2.1 Patch 1
Build #AI-212.5712.43.2112.8609683, built on May 18, 2022
Runtime version: 11.0.2+9 amd64
VM: OpenJDK 64-Bit Server VM by Oracle Corporation
Windows 10 10.0
GC: G1 Young Generation, G1 Old Generation
Memory: 32768M
Cores: 28
Registry: external.system.auto.import.disabled=true
```

Reproduced on both Mac and Windows.
