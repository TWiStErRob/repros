plugins {
    id("io.github.gradle-nexus.publish-plugin") version "1.3.0"
    id("maven-publish")
}

nexusPublishing {
    repositories {
        sonatype()
    }
}
