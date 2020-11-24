package com.example

import android.app.Activity
import android.os.Bundle
import com.google.gson.Gson
import org.intellij.lang.annotations.Language

class MainActivity : Activity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		val mapper = FooDomainMapper()
		@Language("json")
		val json = """
			{
				"NAME": "name",
				"POSITION": {"LATITUDE": 0.0, "LONGITUDE": 0.0}
			}
        """.trimIndent()
		val gson = Gson()
		val dto = gson.fromJson(json, FooDTO::class.java)
		val domain = mapper.map(dto)
		println(domain.ferryName)
		println(domain.latitude)
		println(domain.longitude)
	}
}
