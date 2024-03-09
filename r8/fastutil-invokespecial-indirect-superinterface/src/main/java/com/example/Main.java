package com.example;

import org.intellij.markdown.flavours.MarkdownFlavourDescriptor;
import org.intellij.markdown.flavours.gfm.GFMFlavourDescriptor;
import org.intellij.markdown.parser.MarkdownParser;

public class Main {

	public static void main(String... args) {
		System.out.println("Started Main.main().");
		MarkdownFlavourDescriptor flavour = new GFMFlavourDescriptor();
		var parsedTree = new MarkdownParser(flavour).buildMarkdownTreeFromString("# Title\nDescription");
		System.out.println(parsedTree.getChildren());
	}
}
