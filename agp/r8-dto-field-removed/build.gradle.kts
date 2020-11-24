plugins {
	id("com.android.application") version "4.1.1"
	kotlin("android") version "1.4.20"
}

buildscript {
	repositories {
		google()
		jcenter()
	}
	dependencies {
		classpath("com.android.tools:r8:2.1.67")
		classpath("net.sf.proguard:proguard-gradle:6.2.2")
	}
}

repositories {
	google()
	jcenter()
}

dependencies {
	implementation("org.jetbrains.kotlin:kotlin-stdlib:1.4.20")
	implementation("com.google.code.gson:gson:2.8.6")
}

android {
	buildToolsVersion = "30.0.2"
	compileSdkVersion(30)
	defaultConfig {
		minSdkVersion(21)
		targetSdkVersion(30)
	}
	buildTypes {
		getByName("debug") {
			isMinifyEnabled = true
			proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
		}
	}
}
