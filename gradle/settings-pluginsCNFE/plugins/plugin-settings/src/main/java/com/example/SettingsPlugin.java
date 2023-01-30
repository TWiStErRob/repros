package com.example;

import org.gradle.api.Plugin;
import org.gradle.api.initialization.Settings;

public class SettingsPlugin implements Plugin<Settings> {
	@Override public void apply(Settings target) {
		System.out.println("SettingsPlugin applied: " + OtherClass.getString());
	}
}
