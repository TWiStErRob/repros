plugins {
	id("java-gradle-plugin")
	id("org.gradle.maven-publish")
}

group = "com.example"
version = "1.2.3"

gradlePlugin {
	plugins {
		create("myPlugin") {
			id = "com.example.my-plugin"
			implementationClass = "com.example.MyPlugin"
		}
	}
}

publishing {
	publications {
		// Needs to be delayed, otherwise
		// > * What went wrong:
		// > Publication with name 'pluginMaven' not found.
		afterEvaluate {
			named<MavenPublication>("pluginMaven").configure {
				artifactId = "different-name"
			}
		}
	}
}
