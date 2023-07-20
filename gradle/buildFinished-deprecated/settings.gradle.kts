import org.gradle.kotlin.dsl.support.serviceOf


class DoSomething : FlowAction<FlowParameters.None> {
	override fun execute(parameters: FlowParameters.None) {
		println("Do something")
	}
}
gradle.serviceOf<FlowScope>().always(DoSomething::class.java) { }


class DoSomethingWithResult : FlowAction<DoSomethingWithResult.Parameters> {
	interface Parameters : FlowParameters {
		@get:Input
		val failure: Property<Throwable?>
	}
	override fun execute(parameters: Parameters) {
		if (!parameters.failure.isPresent()) {
			println("Build successful")
		} else {
			println("Build failed: ${parameters.failure.get()}")
		}
	}
}
gradle.serviceOf<FlowScope>().always(DoSomethingWithResult::class.java) {
	val buildResult = gradle.serviceOf<FlowProviders>().buildWorkResult
	parameters.failure.set(buildResult.map { it.failure.orElse(null) })
}
