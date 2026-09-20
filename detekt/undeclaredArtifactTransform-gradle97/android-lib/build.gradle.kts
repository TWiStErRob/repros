plugins {
	id("com.android.library")
	id("dev.detekt")
}

android {
	namespace = "com.example.repro.androidlib"
	compileSdk = 37
}

dependencies {
	implementation(project(":jvm-lib"))
}
