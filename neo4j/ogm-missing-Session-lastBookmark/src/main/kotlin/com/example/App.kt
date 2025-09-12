package com.example

import org.neo4j.harness.Neo4jBuilders
import org.neo4j.ogm.annotation.GeneratedValue
import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.Property
import org.neo4j.ogm.config.Configuration
import org.neo4j.ogm.session.SessionFactory
import org.neo4j.ogm.session.load
import org.neo4j.ogm.session.queryForObject
import java.util.logging.Level

fun main() {
	Neo4jBuilders
		.newInProcessBuilder()
		.build()
		.use { server ->
			println("Server: ${server}")
			val config = Configuration
				.Builder()
				.uri(server.boltURI().toString())
				.withCustomProperty(
					org.neo4j.ogm.drivers.bolt.driver.BoltDriver.CONFIG_PARAMETER_BOLT_LOGGING,
					@Suppress("DEPRECATION") // Deprecated in 2025.08, but unclear replacement.
					org.neo4j.driver.Logging.console(Level.CONFIG)
				)
				.build()
			val modelClasses = listOf(Model::class, BaseNode::class)
				.map { it.qualifiedName ?: error("${it} has no name") }
			println("Bolt: ${config.uri}, packages = ${modelClasses}")
			val sessionFactory = SessionFactory(config, *modelClasses.toTypedArray())
			try {
				val session = sessionFactory.openSession()
				val added: Model = session.queryForObject(
					cypher = $$"""
					MERGE (u:Model { id: $id })
					ON CREATE SET u.name = $name
					ON MATCH SET u.name = $name
					
					RETURN u AS model
				""".trimIndent(),
					parameters = mapOf(
						"id" to "abcd123",
						"name" to "Test Name",
					)
				) ?: error("Model wasn't created.")
				println("Added: ${added}")
				assertEquals(added.id, "abcd123")
				assertEquals(added.name, "Test Name")

				val loaded: Model = session.load(added.id, 1)!!
				println("Loaded: ${loaded}")
				assertEquals(added.id, loaded.id)
				assertEquals(added.name, loaded.name)
			} finally {
				sessionFactory.close()
			}
		}
	println("Done.")
}

@NodeEntity(label = "Model")
class Model : BaseNode() {

	@Id
	@Property(name = "id")
	lateinit var id: String

	@Property(name = "name")
	lateinit var name: String

	override fun toString(): String =
		"Model[${graphId ?: "null"}](${id}: ${name})@${super.toString()}"
}

abstract class BaseNode {

	@Id
	@GeneratedValue
	var graphId: Long? = null
}

private fun assertEquals(expected: Any?, actual: Any?) {
	if (expected != actual) {
		error("Not equal, expected: $expected, actual: $actual")
	}
}
