tasks.register<Delete>("clean") {
	delete(project.layout.buildDirectory)
}
