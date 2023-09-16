plugins {
	id("com.example.root")
}

tasks.register("inner") { doFirst { println("Executed.") } }
