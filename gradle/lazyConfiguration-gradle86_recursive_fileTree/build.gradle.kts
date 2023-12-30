plugins {
	id("io.gitlab.arturbosch.detekt") version "1.23.4"
}

detekt {
	source.setFrom(source.asFileTree.filter { it.name != "exclude.kt" })
	//source.update { it.asFileTree.filter { it.name != "exclude.kt" } }
}
