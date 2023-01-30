plugins {
	id("com.android.library") version "7.4.0"
	id("com.example.build") version "2.0"
}

android {
	compileSdk = 33
	defaultConfig {
		namespace = "com.example.repro"
	}
}

repositories {
	mavenCentral()
	google()
}

project.afterEvaluate { 
	buildscript.configurations.getByName("classpath").run {
		dependencies.forEach { println(it) }
		files.forEach { println(it) }
	}
}
