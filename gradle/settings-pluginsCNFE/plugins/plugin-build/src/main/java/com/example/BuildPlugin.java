package com.example;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import com.android.build.api.dsl.LibraryExtension;

public class BuildPlugin implements Plugin<Project> {
	@Override public void apply(Project target) {
		System.out.println("BuildPlugin applied: " + OtherClass.getString());
		target.getPlugins().withId("com.android.library", (plugin) -> {
			LibraryExtension ext = AndroidUtil.getAndroid(target);
			System.out.println(ext);
		});
	}
}
