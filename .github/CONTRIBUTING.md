# Adding a repro
 * Create a folder under a top-level group folder.
   * Make sure the name is unique, even in the future.
   * Usually the name should start with the part of the software that's broken.
     (e.g. inside `lint` it's the Lint Check's name; inside `gradle` it's `versionCatalog` or `buildScan` subsystems)
 * Create a README.md file.
 * Create the repro (see [below](#creating-a-repro)).
 * Submit the issue with the following repro steps as the minimum:
    ```
     1. https://github.com/TWiStErRob/repros/tree/master/<group>/<repro-slug>
     2. <command to execute>
    ```
 * Add the link to the issue in `README.md`.
 * Commit the repro
   * With a reference to the issue tracker in the commit message:
     * GitHub: `Repro for <org>/<repo>#<num>` (this will be auto-linked) and it'll auto-mention in the corresponding issue:
       ![Image of GitHub's mention for "TWiStErRob added a commit to TWiStErRob/repros that referenced this issue".](https://user-images.githubusercontent.com/2906988/202782865-055cb82b-f2e4-4971-acbf-e680f2fd0def.png)
     * Google: `Repro for issuetracker.google.com/<num>`
     * JetBrains (YouTrack): `Repro for KT-<num>` or `Repro for IDEA-<num>`.
   * No more information needed as the info will be in the Third Party issue tracker or README.md in the worst case.
   * An alternative for `Repro for` is `Workaround for`, in case it's not reproducing the issue, but demonstrating how to work around it.
 * Push to remote.
 * Verify link in issue description's repro steps works as expected.

# Creating a repro
 * Copy an existing one or build from scratch.
 * Remove any company-specific references.
 * Use package name or application ID `com.example` wherever applicable.
 * For Gradle projects include the Gradle Wrapper  
   (`gradlew`, `gradlew.bat`, `gradle/wrapper/gradle-wrapper.properties`, `gradle/wrapper/gradle-wrapper.jar`)
 * Make the repro minimal: no extra lines of code from template or copy-paste; remove as much as possible while still exhibiting the issue.
 * Make sure `.gitignore` covers generated files (e.g. Gradle `build` and `.gradle` folder, `.idea` folder, and any output files generated)
