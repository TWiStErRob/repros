plugins {
	id("java-gradle-plugin")
}

gradlePlugin {
	plugins {
		create("com.example.plugin") {
			id = "com.example.plugin"
			implementationClass = "com.example.ExamplePlugin"
		}
	}
}
