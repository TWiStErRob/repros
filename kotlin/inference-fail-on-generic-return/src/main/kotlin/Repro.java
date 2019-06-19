public class Repro {

	public static void main(String... args) {
		Object oJava = DependencyJava.getStuff();
		System.out.println(DependencyJava.getStuff());
		Object oKt = DependencyKt.getStuff();
		System.out.println(DependencyKt.getStuff());
	}
}
