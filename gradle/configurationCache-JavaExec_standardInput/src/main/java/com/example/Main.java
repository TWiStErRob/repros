package com.example;

import java.io.*;

public class Main {
	public static void main(String... args) throws IOException {
		System.out.println("Enter something: ");
		var reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(reader.readLine());
	}
}
