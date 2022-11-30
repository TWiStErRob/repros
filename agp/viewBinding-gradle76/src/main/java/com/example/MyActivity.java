package com.example;

import android.app.Activity;
import android.os.Bundle;

import com.example.databinding.MyLayoutBinding;

class MyActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		MyLayoutBinding binding = MyLayoutBinding.inflate(getLayoutInflater());
		setContentView(binding.getRoot());
	}
}
