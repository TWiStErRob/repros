https://github.com/renovatebot/renovate/discussions/21408

(Originally reported as https://github.com/renovatebot/renovate/issues/21407, but moved to a discussion.)

Note: the repository uses intentionally outdated versions to have enough new versions to update to and be able to validate the behavior.

## Context
This repo contains
 * a Gradle wrapper and a trivial Gradle project to simulate some reality.
 * a `renovate.json` with these simple? requirements:
   * Gradle major updates are turned off.
   * Gradle minor updates are turned off for < v7.0.
   * Gradle minor updates are turned on for ≥ v7.0.
   * Gradle patch updates are turned on by `:separatePatchReleases`.
 * a GitHub workflow
   * Contains outdated Gradle versions matched by `regexManagers`, see `name:` in `CI.yml` for what's expected of Renovate.
 * a `gradle.properties` file
   * Contains outdated Gradle version matched by `regexManagers`.

`gradle.properties` has no rule on it, so it should be updated together with the Gradle Wrapper. This proves that the `regexManager` setup works together with `packageRules`.

`CI.yml` has multiple patch versions to show that the `regexManager` setup for that file works correctly.

## How to reproduce renovatebot/renovate#21408?

1. Clone this repro.
2. Let Renovate run on it.

Note: when you change between config ensure to check
"Click on this checkbox to rebase all open PRs at once"
in the Dependency Dashboard, otherwise
"Check this box to trigger a request for Renovate to run again on this repository"
doesn't update the PR contents after pushing to default branch. 🙄
(Is this a known issue? Should I raise a separate issue for this?)

## What is the expected behavior?
Renovate PRs for:
 * 3 patch updates of Gradle 6.x.y (separate PRs)
 * 1 minor update of Gradle 7.4.2 to 7.6.1, including:
   * `CI.yml` change for `matrix:`
   * `gradle.properties`'s `test.gradle.version=`
   * Gradle Wrapper

## What is the actual behavior?

Case 1 (in repo): `matchCurrentVersion: <7.0` + `enabled: false`
```json
[
  {
    "description": "Disable updating Gradle CI matrix, they use the latest patch of a specific minor.",
    "matchPackageNames": [ "gradle" ],
    "matchPaths": [ ".github/workflows/CI.yml" ],
    "matchCurrentVersion": "<7.0",
    "matchUpdateTypes": [ "minor" ],
    "enabled": false
  }
]
```

Renovate PRs for:
 * **Extra**: 1 minor update of Gradle 6.x to 6.9.4  
   Even though it's explicitly disabled for <7.0!
 * 3 patch updates of Gradle 6.x.y (separate PRs)
 * 1 minor update of Gradle 7.4.2 to 7.6.1, including:
   * `CI.yml` change for `matrix:`
   * `gradle.properties`'s `test.gradle.version=`
   * Gradle Wrapper

## What is the actual behavior?

Case 2: `enabled: false` & `matchCurrentVersion: >=7.0` + `enabled: true`
```json
[
  {
    "description": "Disable updating Gradle CI matrix, they use the latest patch of a specific minor.",
    "matchPackageNames": [ "gradle" ],
    "matchPaths": [ ".github/workflows/CI.yml" ],
    "matchUpdateTypes": [ "minor" ],
    "enabled": false
  },
  {
     "description": "Enable latest versions.",
     "matchPackageNames": [ "gradle" ],
     "matchPaths": [ ".github/workflows/CI.yml" ],
     "matchCurrentVersion": ">=7.0",
     "matchUpdateTypes": [ "minor" ],
     "enabled": true
  }
]
```

Renovate PRs for:
* 3 patch updates of Gradle 6.x.y (separate PRs)
* 1 minor update of Gradle 7.4.2 to 7.6.1, including:
   * **Missing**: `CI.yml` change for `matrix:`  
     Even though it's re-enabled after disable, as documented at [`packageRules`](https://docs.renovatebot.com/configuration-options/#packagerules):
     > Important to know: Renovate will evaluate all packageRules and not stop once it gets a first match.
     You should order your packageRules in ascending order of importance
     so that more important rules come later and can override settings from earlier rules if needed.
   * `gradle.properties`'s `test.gradle.version=`
   * Gradle Wrapper

## What is the actual behavior?

Case 3: don't have more ideas because the above should "just work", but workaround ideas welcome.
