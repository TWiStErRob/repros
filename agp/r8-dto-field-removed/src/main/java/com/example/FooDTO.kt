package com.example

import com.google.gson.annotations.SerializedName

class FooDTO(
	@SerializedName("NAME")
	val name: String,
	@SerializedName("POSITION")
	val position: PositionDTO,
) {

	class PositionDTO(
		@SerializedName("LATITUDE")
		val latitude: Double,
		@SerializedName("LONGITUDE")
		val longitude: Double
	)
}
