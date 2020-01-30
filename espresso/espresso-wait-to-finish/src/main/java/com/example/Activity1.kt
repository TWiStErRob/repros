package com.example

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class Activity1 : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity1)

		findViewById<View>(R.id.button1).setOnClickListener {
			startActivity(Intent(this, Activity2::class.java))
		}
	}
}
