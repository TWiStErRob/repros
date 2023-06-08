class MyCompositeListener : ProjectEvaluationListener, TaskExecutionGraphListener {
	// region ProjectEvaluationListener
	override fun beforeEvaluate(project: Project) {
		println("beforeEvaluate: $project")
	}
	override fun afterEvaluate(project: Project, state: ProjectState) {
		println("afterEvaluate: $project / $state")
	}
	// endregion ProjectEvaluationListener

	// region TaskExecutionGraphListener
	override fun graphPopulated(teg: TaskExecutionGraph) {
		println("graphPopulated: $teg")
	}
	// endregion TaskExecutionGraphListener
}

val myListener = MyCompositeListener()
project.gradle.addProjectEvaluationListener(myListener)
project.gradle.taskGraph.addTaskExecutionGraphListener(myListener)
