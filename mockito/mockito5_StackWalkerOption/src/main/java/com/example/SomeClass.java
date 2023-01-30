package com.example;

import android.content.Context;

public class SomeClass {
	private final Context context;
	private final SomeInterface someInterface;

	public SomeClass(Context context, SomeInterface someInterface) {
		this.context = context;
		this.someInterface = someInterface;
	}

	public String doSomething() {
		return someInterface.doSomething(context);
	}
}
