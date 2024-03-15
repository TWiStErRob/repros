package com.example;

import com.github.ajalt.mordant.rendering.OverflowWrap;
import com.github.ajalt.mordant.rendering.TextAlign;
import com.github.ajalt.mordant.rendering.TextColors;
import com.github.ajalt.mordant.rendering.Theme;
import com.github.ajalt.mordant.rendering.Whitespace;
import com.github.ajalt.mordant.terminal.Terminal;

public class Main {

	public static void main(String... args) {
		System.out.println("Started Main.main().");
		new Terminal(
				null,
				Theme.Companion.getDefault(),
				null,
				null,
				null,
				8,
				null
		).println(
				TextColors.brightRed.invoke("Hello Ansi! 🌈"),
				Whitespace.PRE,
				TextAlign.NONE,
				OverflowWrap.NORMAL,
				null,
				false
		);
	}
}
