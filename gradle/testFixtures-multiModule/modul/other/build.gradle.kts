plugins {
  id("java") // or "java-library"
}
repositories {
  mavenCentral()
}
dependencies {
  testImplementation("junit:junit:4.13.2")
  testImplementation(testFixtures(project(":modul:one")))
}
