plugins {
	id("com.android.library") version "8.2.0-beta04"
}

android {
	namespace = "com.example.lib"
	compileSdk = 34
	defaultConfig.minSdk = 14
}

// Workaround:
/*
// No filter, big bang for EVERYTHING. In an Android build AGP tasks will be the majority anyway.
tasks.configureEach {
	if (this::class.qualifiedName.orEmpty().startsWith("com.android.build.gradle.")) {
		usesBuildService<com.android.build.gradle.internal.SdkComponentsBuildService>()
		usesBuildService<com.android.build.gradle.internal.errors.SyncIssueReporterImpl.GlobalSyncIssueService>()
		usesBuildService<com.android.build.gradle.internal.ide.dependencies.LibraryDependencyCacheBuildService>()
		usesBuildService<com.android.build.gradle.internal.ide.dependencies.LibraryDependencyCacheBuildService>()
		usesBuildService<com.android.build.gradle.internal.ide.dependencies.MavenCoordinatesCacheBuildService>()
		usesBuildService<com.android.build.gradle.internal.profile.AnalyticsService>()
		usesBuildService<com.android.build.gradle.internal.services.Aapt2DaemonBuildService>()
		usesBuildService<com.android.build.gradle.internal.services.AndroidLocationsBuildService>()
		usesBuildService<com.android.build.gradle.internal.services.LintClassLoaderBuildService>()
		usesBuildService<com.android.build.gradle.internal.services.SymbolTableBuildService>()
	}
}

// Long-winded because Gradle down-casts Provider<out BuildService> to RegisteredBuildServiceProvider.
inline fun <reified T : BuildService<*>> Task.usesBuildService() {
	val buildServiceProvider =
		project
			.gradle
			.sharedServices
			.registrations
			.single { it.name.startsWith(T::class.java.name) }
			.service
	usesService(buildServiceProvider)
}
*/