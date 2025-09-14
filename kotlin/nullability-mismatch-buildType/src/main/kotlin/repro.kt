import com.android.build.gradle.BaseExtension

fun f(android: BaseExtension) {
	android.buildTypes.configureEach {  // IDEA hint: `it: *..*?`
		println(it)
	}
}
