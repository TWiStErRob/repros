# Uncommenting this solves the issue. 
#-dontshrink

# Keeping @SerializedName solves the issue.
#-keep,allowobfuscation @interface com.google.gson.annotations.SerializedName
#-keepclassmembers,allowobfuscation class * {
#  @com.google.gson.annotations.SerializedName <fields>;
#}

-dontobfuscate
-dontoptimize
