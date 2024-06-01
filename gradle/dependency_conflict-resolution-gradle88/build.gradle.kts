plugins {
	id("org.jetbrains.kotlin.jvm") version "1.9.24"
}

dependencies {
	compileOnly(enforcedPlatform(libs.kotlin.bom))
	api(enforcedPlatform(libs.kotlin.bom)) {
		version { strictly("1.9.24") }
	}
}
