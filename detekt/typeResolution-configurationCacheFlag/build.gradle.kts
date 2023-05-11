tasks.register<MyDetekt>("detekt") {
	// Override via property (implementation here is just an example, it can be more complicated than this (env, etc.))
	flag.set(providers.gradleProperty("com.example.enableTypeSolving").map(String::toBoolean))
}

tasks.register<MyDetekt>("detektFull") {
	flag.set(true)
}

tasks.register<MyDetekt>("detektLite") {
	flag.set(false)
}

@UntrackedTask(because = "Output is console.")
abstract class MyDetekt : DefaultTask() {
	@get:Input
	abstract val flag: Property<Boolean>

	@TaskAction
	fun run() {
		println("Executing ${this} with ${flag.get()}.")
	}
}
