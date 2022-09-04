tasks.register("generateContent") {
	doFirst {
		file("file1").writeText("1")
		file("file2").writeText("2")
		file("file3").writeText("3")
	}
}

tasks.register<Delete>("cleanContent") {
	delete(fileTree(rootDir) { include("file*") })
}
