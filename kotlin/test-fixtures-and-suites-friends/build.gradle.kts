import org.jetbrains.kotlin.gradle.utils.extendsFrom

plugins {
	id("org.gradle.java")
	id("org.gradle.java-test-fixtures")
	id("org.gradle.jvm-test-suite")
	id("org.jetbrains.kotlin.jvm") version "1.8.20"
	id("org.jetbrains.kotlin.kapt") version "1.8.20"
}

// | > Task :compileTestFixturesKotlin FAILED
// | e: src/testFixtures/kotlin/com/example/UsagesFromKotlin.kt
// | Cannot access 'MainKotlinInternal': it is internal in 'com.example'
kotlin.target.compilations { named("testFixtures") { associateWith(getByName("main")) } }

@Suppress("UnstableApiUsage", "UNUSED_VARIABLE")
testing {
	suites {
		val test = JvmTestSuitePlugin.DEFAULT_TEST_SUITE_NAME(JvmTestSuite::class) {
			testType.set(TestSuiteType.UNIT_TEST)

			// | > Task :compileTestKotlin FAILED
			// | e: src/test/kotlin/com/example/UsagesFromKotlin.kt
			// | Cannot access 'TestFixturesKotlinInternal': it is internal in 'com.example'
			kotlin.target.compilations { named("test") { associateWith(getByName("testFixtures")) } }
		}

		val integrationTest by registering(JvmTestSuite::class) {
			testType.set(TestSuiteType.INTEGRATION_TEST)

			// | > Task :compileIntegrationTestKotlin FAILED
			// | e: src/integrationTest/kotlin/com/example/UsagesFromKotlin.kt
			// | Unresolved reference: MainJavaPublic
			// | Unresolved reference: MainJavaPackagePrivate
			// | Unresolved reference: MainKotlinPublic
			// | Unresolved reference: MainKotlinInternal
			dependencies { implementation(project()) }
			// | > Task :compileIntegrationTestKotlin FAILED
			// | e: src/integrationTest/kotlin/com/example/UsagesFromKotlin.kt
			// | Cannot access 'MainKotlinInternal': it is internal in 'com.example'
			kotlin.target.compilations { named("integrationTest") { associateWith(getByName("main")) } }
			// In a real project this might be also necessary to get the full classpath correctly:
			//propagateDependencies(project.sourceSets.main.get().implementationConfigurationName)

			// | > Task :compileIntegrationTestKotlin FAILED
			// | e: src/integrationTest/kotlin/com/example/UsagesFromKotlin.kt
			// | Unresolved reference: TestFixturesJavaPublic
			// | Unresolved reference: TestFixturesKotlinPublic
			// | Unresolved reference: TestFixturesJavaPackagePrivate
			// | Unresolved reference: TestFixturesKotlinInternal
			dependencies { implementation(testFixtures(project())) }
			// | > Task :compileIntegrationTestKotlin FAILED
			// | e: src/integrationTest/kotlin/com/example/UsagesFromKotlin.kt
			// | Cannot access 'TestFixturesKotlinInternal': it is internal in 'com.example'
			kotlin.target.compilations { named("integrationTest") { associateWith(getByName("testFixtures")) } }
			// In a real project this might be also necessary to get the full classpath correctly:
			//propagateDependencies(project.sourceSets.testFixtures.get().implementationConfigurationName)
		}
	}
}

@Suppress("UnstableApiUsage")
fun JvmTestSuite.propagateDependencies(configurationName: String) {
	// Depend on main project's internal dependencies.
	project.configurations.named(sources.implementationConfigurationName)
		.extendsFrom(project.configurations.named(configurationName))
}
