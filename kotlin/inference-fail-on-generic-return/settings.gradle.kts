pluginManagement {
	repositories {
		@Suppress("UnstableApiUsage")
		gradlePluginPortal()
		maven { name = "Kotlin EAP"; setUrl("https://dl.bintray.com/kotlin/kotlin-eap/") }
		maven { name = "Kotlin Dev"; setUrl("https://dl.bintray.com/kotlin/kotlin-dev/") }
	}
}
