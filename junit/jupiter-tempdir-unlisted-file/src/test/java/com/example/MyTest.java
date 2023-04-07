package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class MyTest {
	@Test
	void testLeavesFileHandleOpen(@TempDir File tempDir) throws FileNotFoundException {
		new FileOutputStream(new File(tempDir, "file.txt"));
	}
}
