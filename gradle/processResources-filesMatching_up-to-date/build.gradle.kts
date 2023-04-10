plugins {
	id("org.gradle.java")
}

testing.suites.named<JvmTestSuite>("test") {
	useJUnitJupiter()
}

tasks.named<ProcessResources>("processResources") {
	val replacements= mapOf(
		"foo" to "bar"
	)
	val processedFiles = listOf(
		"**/a.txt",
		//"**/b.txt",
	)
	filesMatching(processedFiles) {
		filter(mapOf("tokens" to replacements), org.apache.tools.ant.filters.ReplaceTokens::class.java)
	}
}
