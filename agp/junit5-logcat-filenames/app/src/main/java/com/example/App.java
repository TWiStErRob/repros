package com.example;

public class App {

	private final String input;

	public App(String input) {
		this.input = input;
	}

	@Override public String toString() {
		return "app " + input;
	}
}
