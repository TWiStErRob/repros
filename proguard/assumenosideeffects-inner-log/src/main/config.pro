-dontobfuscate
#-allowaccessmodification
#-optimizations !code/simplification/cast,!class/merging/*
-optimizationpasses 10

# Entry point
-keep class MyFragment1 {}
-keep class MyFragment2 {}
-keep class MyFragment3 {}

# Remove Logging
-dontnote org.slf4j.helpers.SubstituteLogger
-assumenosideeffects interface org.slf4j.Logger {
	public boolean is*Enabled(...);
	public void trace(...);
	public void info(...);
	public void warn(...);
	public void debug(...);
	public void error(...);
}
-assumenosideeffects class org.slf4j.LoggerFactory {
	public static org.slf4j.Logger getLogger(...);
}
#-assumenosideeffects class ** {
#	final org.slf4j.Logger LOG;
#	static synthetic org.slf4j.Logger access$*();
#}
