plugins {
	id("com.gradle.plugin-publish") version "1.1.0"
	id("com.github.johnrengelman.shadow") version "7.1.2"
}

tasks.shadowJar {
	archiveClassifier.set("")
}

afterEvaluate {
	configurations.named(com.github.jengelman.gradle.plugins.shadow.ShadowBasePlugin.CONFIGURATION_NAME).configure {
		// Workaround https://github.com/gradle/gradle/issues/23928
		// Undo part of com.gradle.publish.PublishTaskShadowAction.manipulateDependencies()
		//this.dependencies.remove(project.dependencies.gradleApi())
	}
}
