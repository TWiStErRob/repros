plugins {
	id("org.jetbrains.kotlin.jvm")
}

dependencies {
	if (project.property("repro.with.fix").toString().toBooleanStrict()) {
		implementation(project(":retained-annotation"))
	} else {
		implementation("androidx.annotation:annotation:1.9.0")
	}
}
