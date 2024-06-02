https://github.com/renovatebot/renovate/discussions/29260#discussioncomment-9578267

There are two violations to the rule:

> WARN: Use matchDepNames instead of matchPackageNames

 * `io.gitlab.arturbosch.detekt`
 * `com.android.application`

But only one of them logs at a time.

```
DEBUG: Looking up io.gitlab.arturbosch.detekt:detekt-gradle-plugin in repository https://dl.google.com/android/maven2/
DEBUG: Looking up com.android.tools.build:gradle in repository https://dl.google.com/android/maven2/
WARN: Use matchDepNames instead of matchPackageNames
{
  "packageRule": {
    "groupName": "Detekt",
    "matchPackageNames": [
      "io.gitlab.arturbosch.detekt",
      "io.gitlab.arturbosch.detekt:detekt-gradle-plugin"
    ]
  }
  "packageName": "io.gitlab.arturbosch.detekt:io.gitlab.arturbosch.detekt.gradle.plugin"
  "depName": "io.gitlab.arturbosch.detekt"
}

DEBUG: Looking up io.gitlab.arturbosch.detekt:io.gitlab.arturbosch.detekt.gradle.plugin in repository https://dl.google.com/android/maven2/
DEBUG: Looking up com.android.application:com.android.application.gradle.plugin in repository https://dl.google.com/android/maven2/
```

after fixing detekt like this:

```diff
       "matchPackageNames": [
-        "io.gitlab.arturbosch.detekt",
         "io.gitlab.arturbosch.detekt:detekt-gradle-plugin"
       ]
+      "matchDepNames": [
+        "io.gitlab.arturbosch.detekt"
+      ]
```

the logs changed to:

```
DEBUG: Looking up io.gitlab.arturbosch.detekt:detekt-gradle-plugin in repository https://dl.google.com/android/maven2/
DEBUG: Looking up com.android.tools.build:gradle in repository https://dl.google.com/android/maven2/
DEBUG: Looking up io.gitlab.arturbosch.detekt:io.gitlab.arturbosch.detekt.gradle.plugin in repository https://dl.google.com/android/maven2/
WARN: Use matchDepNames instead of matchPackageNames
{
  "packageRule": {
    "groupName": "Android Gradle Plugin",
    "matchPackageNames": [
      "com.android.tools.build:gradle",
      "com.android.application"
    ]
  }
  "packageName": "com.android.application:com.android.application.gradle.plugin"
  "depName": "com.android.application"
}

DEBUG: Looking up com.android.application:com.android.application.gradle.plugin in repository https://dl.google.com/android/maven2/
```
