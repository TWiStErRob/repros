plugins {
	kotlin("jvm") version "1.3.50-dev-1148"
}

repositories {
	maven { name = "Kotlin EAP"; setUrl("https://dl.bintray.com/kotlin/kotlin-eap/") }
	maven { name = "Kotlin Dev"; setUrl("https://dl.bintray.com/kotlin/kotlin-dev/") }
	mavenCentral()
	jcenter()
}

dependencies {
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
}
