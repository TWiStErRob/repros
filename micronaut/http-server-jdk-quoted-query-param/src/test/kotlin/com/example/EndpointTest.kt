package com.example

import io.micronaut.context.ApplicationContext
import io.micronaut.context.annotation.Requires
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.QueryValue
import io.micronaut.http.client.HttpClient
import io.micronaut.runtime.server.EmbeddedServer
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class EndpointTest {

	@Test
	fun test() {
		ApplicationContext.run(
			EmbeddedServer::class.java,
			mapOf(
				"test.class" to "EndpointTest",
			),
		).use { endpoint ->
			endpoint.applicationContext
				.createBean(HttpClient::class.java, endpoint.url)
				.toBlocking()
				.use { client ->
					val request = HttpRequest
						.GET<String>("/endpoint")
						.uri {
							it.queryParam("query", "\"quoted\"")
						}
					val exchange: HttpResponse<String> = client.exchange(request, String::class.java)
					assertEquals(HttpStatus.OK, exchange.status)
					assertEquals("response-text", exchange.body())
				}
		}
	}
}

@Requires(property = "test.class", value = "EndpointTest")
@Controller
private class TestEndpoint {
	@Get(uri = "/endpoint")
	fun endpoint(@QueryValue("query") query: String): String {
		assertEquals("\"quoted\"", query)
		return "response-text"
	}
}
