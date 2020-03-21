import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	kotlin("jvm") version "1.3.70"
}

repositories {
	jcenter()
}

dependencies {
	implementation(kotlin("stdlib-jdk7", org.jetbrains.kotlin.config.KotlinCompilerVersion.VERSION))
}

// https://kotlinlang.org/docs/reference/using-gradle.html#compiler-options
tasks.withType<KotlinCompile>().configureEach {
	kotlinOptions {
		// These are not necessary, but can be set up in any way.
//		verbose = true
//		suppressWarnings = false
//		allWarningsAsErrors = true
	}
	val taskOutput = StringBuilder()
	logging.addStandardOutputListener { taskOutput.append(it) }
	logging.level = LogLevel.INFO
	doLast {
		fun CharSequence.hasInfoWithError(): Boolean =
			"'when' expression on sealed classes is recommended to be exhaustive" in this
		if (taskOutput.hasInfoWithError()) {
			// assumes that each problem is listed on a separate line
			val infos = taskOutput
				.lineSequence()
				.filter(String::hasInfoWithError)
				.joinToString(separator = "\n")
			throw Exception("kotlinc infos considered as errors found, see compiler output for details, here is some info:\n$infos")
		}
	}
}
