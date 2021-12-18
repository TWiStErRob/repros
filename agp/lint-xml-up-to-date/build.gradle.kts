plugins {
	id("com.android.application") version "7.0.4" apply false
}

/* WORKAROUND: if this is uncommented it works as expected.
allprojects {
	val project = this
	project.plugins.withId("com.android.base") {
		project.tasks.withType<com.android.build.gradle.internal.lint.AndroidLintTask>().configureEach {
			this.inputs.files(project.rootProject.file("lint.xml")).withPathSensitivity(PathSensitivity.RELATIVE)
			this.inputs.files(project.file("lint.xml")).withPathSensitivity(PathSensitivity.RELATIVE)
		}
	}
}
*/
