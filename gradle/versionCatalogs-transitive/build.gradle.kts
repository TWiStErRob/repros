plugins {
	`java-library`
}

dependencies {
	add("compileOnly", "g:a:v")
	add("compileOnly", "g:a:v") { isTransitive = false }

	add("compileOnly", libs.g.a)
	add("compileOnly", libs.g.a) { isTransitive = false }
}
