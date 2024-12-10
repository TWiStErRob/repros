package com.example.repro;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.libraries.places.api.Places;

public class MainActivity extends Activity {

	@Override protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Places.initialize(getApplicationContext(), "my-api-key");
	}
}
