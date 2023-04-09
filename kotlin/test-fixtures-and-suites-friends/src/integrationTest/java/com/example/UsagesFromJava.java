package com.example;

// Only visible when integrationTest is associated with main.
@SuppressWarnings("unused")
class UseMainFromJava {
	private final MainJavaPublic useJavaPublic = new MainJavaPublic();
	private final MainJavaPackagePrivate useJavaInternal = new MainJavaPackagePrivate();
	private final MainKotlinPublic useKotlinPublic = new MainKotlinPublic();
	private final MainKotlinInternal useKotlinInternal = new MainKotlinInternal(); // RED
}

// Not visible, because test and integrationTest are siblings, no dependency or friend relationship.
//@SuppressWarnings("unused")
//class UseTestFromJava {
//	private final TestJavaPublic useJavaPublic = new TestJavaPublic();
//	private final TestJavaPackagePrivate useJavaInternal = new TestJavaPackagePrivate();
//	private final TestKotlinPublic useKotlinPublic = new TestKotlinPublic();
//	private final TestKotlinInternal useKotlinInternal = new TestKotlinInternal();
//}

// Only visible when integrationTest is associated with testFixtures.
@SuppressWarnings("unused")
class UseTestFixturesFromJava {
	private final TestFixturesJavaPublic useJavaPublic = new TestFixturesJavaPublic();
	private final TestFixturesKotlinPublic useKotlinPublic = new TestFixturesKotlinPublic();
	private final TestFixturesJavaPackagePrivate useJavaInternal = new TestFixturesJavaPackagePrivate();
	private final TestFixturesKotlinInternal useKotlinInternal = new TestFixturesKotlinInternal(); // RED
}

// Same source set, everything is good.
@SuppressWarnings("unused")
class UseIntegrationTestFromJava {
	private final IntegrationTestJavaPublic useJavaPublic = new IntegrationTestJavaPublic();
	private final IntegrationTestKotlinPublic useKotlinPublic = new IntegrationTestKotlinPublic();
	private final IntegrationTestJavaPackagePrivate useJavaInternal = new IntegrationTestJavaPackagePrivate();
	private final IntegrationTestKotlinInternal useKotlinInternal = new IntegrationTestKotlinInternal();
}
