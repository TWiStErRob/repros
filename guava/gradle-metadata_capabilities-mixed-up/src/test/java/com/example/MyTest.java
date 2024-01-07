package com.example;

import com.android.resources.ResourceType;
import com.google.common.collect.Sets;
import org.junit.Test;

public class MyTest {

	@Test
	public void test() {
		System.out.println(Sets.class.getProtectionDomain().getCodeSource().getLocation());
		ResourceType.values();
	}
}
