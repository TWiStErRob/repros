package com.example;

import android.app.Application;
import android.content.Context;

import javax.inject.Inject;
import dagger.hilt.android.HiltAndroidApp;
import dagger.hilt.android.qualifiers.ApplicationContext;

@HiltAndroidApp
public class App extends Application {
	// TODEL https://github.com/google/dagger/issues/3601
	@Inject @ApplicationContext Context context;
}
