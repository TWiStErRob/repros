val mustRunAfterProvider = tasks.register("mustRunAfterThis")
val dependsOnProvider = tasks.register("dependsOnThis")

tasks.register("someTask") {
	mustRunAfter(mustRunAfterProvider)
	dependsOn(dependsOnProvider)
}

tasks.register("someOtherTask") {
	dependsOn("someTask")
}
