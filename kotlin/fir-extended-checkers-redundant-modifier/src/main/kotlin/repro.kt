public data class Location private constructor(
	internal val ip: String,
	internal val port: Int,
) {
	public constructor(location: String) : this(
		location.split(":")[0],
		location.split(":")[1].toInt(),
	)
}
