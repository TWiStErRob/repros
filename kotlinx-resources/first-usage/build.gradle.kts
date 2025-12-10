plugins {
	kotlin("multiplatform") version "2.2.21"
	id("com.goncalossilva.resources") version "0.10.1"
}

kotlin {
	js(IR) {
		browser {
		}
	}
	jvm()
	@Suppress("unused")
	sourceSets {
		val commonMain by getting {
			dependencies {
				implementation(kotlin("stdlib"))
			}
		}
		val commonTest by getting {
			dependencies {
				implementation(kotlin("test"))
				implementation("com.goncalossilva:resources:0.10.1")
			}
		}
	}
}
