package com.example

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class Activity2 : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity2)

		findViewById<View>(R.id.button2).setOnClickListener {
			finish()
		}
	}
}
