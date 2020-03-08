plugins {
	id("com.android.library")
	kotlin("android")
	kotlin("kapt")
}

android {
	buildToolsVersion("29.0.3")
	compileSdkVersion(29)
	defaultConfig {
		minSdkVersion(21)
		targetSdkVersion(29)
	}
}

repositories {
	google()
	jcenter()
}

dependencies {
	implementation(kotlin("stdlib-jdk7", org.jetbrains.kotlin.config.KotlinCompilerVersion.VERSION))

	implementation("org.parceler:parceler-api:1.1.13")
	kapt("org.parceler:parceler:1.1.13")
}

android.libraryVariants.all {
	val variant: com.android.build.gradle.api.BaseVariant = this
	afterEvaluate {
		tasks.named("kapt${variant.name.capitalize()}Kotlin") {
			val taskOutput = StringBuilder()
			logging.addStandardOutputListener { taskOutput.append(it) }
			doLast {
				if ("warning: Parceler: " in taskOutput) {
					throw Exception(
						"""
						There are problems with Parceler, please fix them. See build output for details.
						If it says 'Reflection is required', use one of these patterns:
						
						@Parcel(Parcel.Serialization.BEAN)
						data class Parceled @ParcelConstructor constructor(
							val field: Type,
							...
						)
						
						@Parcel(Parcel.Serialization.BEAN)
						class Parceled {
							var field: Type
							...
						}
						
						@Parcel
						data class Parceled @ParcelConstructor constructor(
							@JvmField val field: Type,
							...
						)
						""".trimIndent()
					)
				}
			}
		}
	}
}
