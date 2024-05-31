@file:DependsOn("com.fasterxml.jackson.module:jackson-module-kotlin:2.17.1")
@file:DependsOn("com.fasterxml.jackson.core:jackson-databind:2.17.1")

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue

data class Response(
	val list: List<Data>,
) {
	data class Data(
		val id: String,
	)
}

val response: Response = jacksonObjectMapper().readValue("""{ "list": [] }""")
println(response.list.size)
