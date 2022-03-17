class X : Dependency() {
	fun main() {
		val propLambda: () -> String = { stuff }
		val propRef: () -> String = ::stuff // UNSUPPORTED
		val methodRef: () -> String = ::getStuff
	}
}
