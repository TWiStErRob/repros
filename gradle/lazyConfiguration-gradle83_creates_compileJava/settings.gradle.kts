// Lifecycle events are registered here, so they are ready by the time the first plugin is applied.

gradle.taskGraph.whenReady {
	println("Task graph ready.")
}

gradle.beforeProject {
	tasks.configureEach {
		Exception("${this@configureEach} was created for ${this@beforeProject}.").printStackTrace()
	}
}
