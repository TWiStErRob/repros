plugins {
	`java-library`
	`maven-publish`
	id("io.github.gradle-nexus.publish-plugin") version "1.3.0"
}

group = "com.example.library"
version = "1.0.0"

publishing {
	publications {
		create<MavenPublication>("mavenJava") {
			from(components["java"])
		}
	}
}

nexusPublishing {
	repositories {
		create("myNexus") {
			nexusUrl.set(uri("https://your-server.com/staging/"))
			snapshotRepositoryUrl.set(uri("https://your-server.com/snapshot/"))
			username.set("your-username")
			password.set("your-password")
		}
	}
}
