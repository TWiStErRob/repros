https://github.com/renovatebot/renovate/issues/17635

## Context
This repo contains
 * the `self-hosted` "project" that can be executed.
 * it contains two Renovate-compatible dependencies (both out of date):
   * `gradle/libs.versions.toml` > `junit:junit`
   * `self-hosted/package.json` > `renovate`
 * the `main` branch contains a renovate.json that excludes `gradle/**`, so it'll pick up the outdated `renovate` dep.
 * the `some_branch` branch contains a modified renovate.json that excludes `self-hosted/**`, so it'll pick up the outdated `junit:junit` dep.
 * a PR (#1) from `some_branch` to `main` and the repro step 5 is simulating the verification (QA) of this configuration change PR. The diff is
```diff
"ignorePaths": [
-	"gradle/**"
+	"self-hosted/**"
]
```

## How to reproduce renovatebot/renovate#17635?

1. Clone this repository
2. Run `npm install` in `self-hosted` folder.
3. `set RENOVATE_TOKEN=ghp_...`
4. `set LOG_LEVEL=debug`
5. Run `npm run renovate > some_branch.log` in `self-hosted` folder.
6. Edit `config.js` and **remove** these lines:
   * baseBranches
   * useBaseBranchConfig
7. Run `npm run renovate > main.log` in `self-hosted` folder.

## What is the expected behavior?
`printConfig: true` is set in `config.json` and therefore I'm expecting to see the merged configuration after the `some_branch` config is `merge`d into the `main` config.

## What is the actual behavior?

`cat main.log | grep "ignorePaths"` yields this 5 times
```
"ignorePaths": ["gradle/**"]
```

`cat some_branch.log | grep "ignorePaths"` yields this 5 times
```
"ignorePaths": ["gradle/**"]
```

That is, there's 0 mention of the overridden (merged) `self-hosted/**` ignore.

BUT
observe `packageFiles with updates` in the logs:
 * in `main.log` it shows the `npm` manager finding  
   `"packageFile": "self-hosted/package.json",`
 * in `some_branch.log` it shows the `gradle` manager finding  
   `"packageFile": "gradle/libs.versions.toml",`

and this proves that the `ignorePaths` is actually overridden.
