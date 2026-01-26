import org.gradle.kotlin.dsl.support.serviceOf

plugins {
    id("org.gradle.java-library")
    id("org.jetbrains.kotlin.jvm")
}

kotlin {
    jvmToolchain(17)
}

dependencies {
    //api(project(":library-standin"))
}

val myClasses = tasks.register<Sync>("myClasses") {
    into(layout.buildDirectory.dir("my-classes"))

    val patchConfiguration = configurations.detachedConfiguration(
        dependencies.project(":library-standin"),
    )
    patchConfiguration.isTransitive = false

    val archiveOps = gradle.serviceOf<ArchiveOperations>()
    fun Configuration.asZipTree() =
        elements.map { archiveOps.zipTree(it.single().asFile) }

    from(patchConfiguration.asZipTree())
}

tasks.named<Jar>("jar") { from(myClasses) }
// or
//tasks.named<ProcessResources>("processResources") { from(myClasses) }
