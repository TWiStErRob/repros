package com.example

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.application.log
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.plugins.calllogging.CallLogging
import io.ktor.server.plugins.statuspages.StatusPages
import io.ktor.server.response.respondText
import io.ktor.server.routing.application
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
import org.slf4j.event.Level

public fun main() {
	embeddedServer(
		factory = Netty,
		port = 8081,
		module = Application::main
	).start(wait = true)
}

public fun Application.main() {
	install(CallLogging) {
		level = Level.INFO
	}
	routing {
		trace { application.log.trace(it.buildText()) }
	}
	install(StatusPages) {
		exception<Throwable> { call, cause ->
			call.application.log.error("Unhandled exception", cause)
			call.respondText(text = cause.stackTraceToString(), status = HttpStatusCode.InternalServerError)
		}
	}
	val clsDuringInit = Thread.currentThread().contextClassLoader.loadClass("com.example.SomeClass")
	routing {
		get("/") {
			val clsDuringRequest = SomeClass::class.java
			val instance = clsDuringInit.constructors.single().newInstance()
			if (instance::class.java.isAssignableFrom(clsDuringRequest)) {
				call.respondText(
					text = """
						AOK!
						init: ${clsDuringInit.classLoader}
						request: ${clsDuringRequest.classLoader}
					""".trimIndent(),
					status = HttpStatusCode.OK,
				)
			} else {
				call.respondText(
					text = """
						What?
						init: ${clsDuringInit.classLoader}
						request: ${clsDuringRequest.classLoader}
					""".trimIndent(),
					status = HttpStatusCode.InternalServerError,
				)
			}
		}
	}
}
