fun main() {
	val anyJava: Any? = DependencyJava.getStuff()
	println(DependencyJava.getStuff())
	val anyKt: Any? = getStuff()
	println(getStuff())
}
