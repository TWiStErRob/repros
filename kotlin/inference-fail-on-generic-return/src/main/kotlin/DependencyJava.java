public class DependencyJava {

	public static <T extends Base> T getStuff() {
		// assume real implementation is correct as likely has an unchecked cast
		return null;
	}
}
