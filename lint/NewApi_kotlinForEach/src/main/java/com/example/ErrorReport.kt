package com.example

import org.json.JSONObject

abstract class ErrorReport {

	abstract fun toMap(): Map<String, String>

	fun getReportJsonString(): String {
		val jsonObject = JSONObject()
		toMap().forEach { (key, value) -> jsonObject.put(key, value) }
		return jsonObject.toString()
	}
}
