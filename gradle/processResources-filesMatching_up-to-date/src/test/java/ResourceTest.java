import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.ClasspathAccess;

public class ResourceTest {

	@Test void testAContents() {
		String a = read(ClasspathAccess.class.getResourceAsStream("/a.txt"));

		assertEquals("bar", a); // processed
	}

	@Test void testBContents() {
		String b = read(ClasspathAccess.class.getResourceAsStream("/b.txt"));

		assertEquals("@foo@", b); // unprocessed
	}

	private static String read(InputStream stream) {
		return new BufferedReader(new InputStreamReader(stream))
				.lines()
				.collect(Collectors.joining("\n"));
	}
}
