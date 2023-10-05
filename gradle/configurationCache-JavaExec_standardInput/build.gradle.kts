plugins {
	id("org.gradle.java")
}

tasks.register<JavaExec>("echo") {
	mainClass = "com.example.Main"
	classpath = files(sourceSets.main.map { it.runtimeClasspath })
	standardInput = System.`in`
	// Workaround:
	//doFirst { standardInput = System.`in` }
}
