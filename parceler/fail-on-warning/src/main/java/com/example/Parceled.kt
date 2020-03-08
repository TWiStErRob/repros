package com.example

import org.parceler.Parcel
import org.parceler.ParcelConstructor

@Parcel
data class Parceled @ParcelConstructor constructor(
	val privateField: String
)
