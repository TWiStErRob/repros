package com.example;

import android.util.Log;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class AnnotationFilterTest {

	@Test
	@MyAnnotation1
	@MyAnnotation2
	public void test1_ann1_ann2() {
	}

	@Test
	@MyAnnotation1
	public void test2_ann1() {
	}

	@Test
	@MyAnnotation2
	public void test3_ann2() {
	}

	@Test
	@MyAnnotation1
	@MyAnnotation2
	public void test4_ann1_ann2() {
	}

	@Test
	public void test5_noann() {
	}
}
