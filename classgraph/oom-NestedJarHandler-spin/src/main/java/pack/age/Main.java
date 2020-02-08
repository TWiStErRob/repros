package pack.age;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.ScanResult;

public class Main {

	public static void main(String... args) {
		ScanResult result = new ClassGraph()
//				.removeTemporaryFilesAfterScan() // doesn't repro by itself, not interrupted
//				.disableNestedJarScanning() // need to be enabled
				.whitelistPackages("pack.age")
				.verbose()
				.scan()
				;
		System.out.println("Scanned: " + result);
	}
}
