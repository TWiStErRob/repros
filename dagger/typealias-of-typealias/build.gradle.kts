plugins {
	kotlin("jvm") version "2.4.10"
	id("com.google.devtools.ksp") version "2.3.11"
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("com.google.dagger:dagger:2.60.1")
	ksp("com.google.dagger:dagger-compiler:2.60.1")
}
