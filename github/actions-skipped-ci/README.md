https://github.com/github/docs/issues/21865

Repro:
 * Push this folder into a new repository.
 * Create 4 pull requests:
   * branch: `project1`, "Update Project 1 only", change `project1/some/file`
   * branch: `project2`, "Update Project 2 only", change `project2/other/file`
   * branch: `project3`, "Update Project 3 only", change `project3/another/file`
   * branch: `project12`, "Update Project 1 and Project 2 both", change `project1/some/file` and `project2/other/file`
 * Observe CI execution as documented in GitHub issue