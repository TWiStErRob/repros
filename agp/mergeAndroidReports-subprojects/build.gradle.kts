plugins {
	id("com.android.application") version "7.1.2" apply false
}

// Workaround that fixes the issue: uncomment the next line.
//subprojects.forEach { evaluationDependsOn(it.path) }

apply(plugin = "android-reporting")
