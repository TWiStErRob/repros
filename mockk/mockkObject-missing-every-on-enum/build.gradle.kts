plugins {
	kotlin("jvm") version "1.9.20"
}

repositories {
	mavenCentral()
}

dependencies {
	implementation(kotlin("stdlib"))

	testImplementation("junit:junit:4.13.2")
	testImplementation("io.mockk:mockk:1.13.8")
}
