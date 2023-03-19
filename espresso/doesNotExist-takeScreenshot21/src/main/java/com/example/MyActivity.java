package com.example;

import android.app.Activity;

import android.app.AlertDialog;

public class MyActivity extends Activity {
	private AlertDialog dialog;
	@Override protected void onStart() {
		super.onStart();
		dialog = new AlertDialog.Builder(this)
				.setPositiveButton("positive", null)
				.setNegativeButton("negative", null)
				.setNeutralButton("neutral", null)
				.setCancelable(true)
				.show();
	}

	@Override protected void onStop() {
		dialog.dismiss();
		super.onStop();
	}
}
