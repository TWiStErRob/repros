package com.example;

import org.gradle.api.Project;
import com.android.build.api.dsl.LibraryExtension;

public class AndroidUtil {
	public static LibraryExtension getAndroid(Project project) {
		System.out.println("AndroidUtil");
		return (LibraryExtension) project.getExtensions().getByName("android");
	}
}
