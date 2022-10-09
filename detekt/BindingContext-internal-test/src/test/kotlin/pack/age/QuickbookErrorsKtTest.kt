package pack.age

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class QuickbookErrorsKtTest {

	private class FakeResponse(
		val data: String,
		override val errors: List<String>?
	) : QuickbookErrors

	@Test fun `empty error list results in data`() {
		val response = FakeResponse("test data", emptyList())

		val result: String = response.throwErrorOrReturn { it.data }

		assertEquals(response.data, result)
	}

	@Test fun `no error list results in data`() {
		val response = FakeResponse("test data", null)

		val result: String = response.throwErrorOrReturn { it.data }

		assertEquals(response.data, result)
	}

	@Test fun `one error results in error`() {
		val response = FakeResponse("test data", listOf("fake error"))

		assertThrows<QuickbookErrorsException> { response.throwErrorOrReturn { it.data } }.let { result ->
			assertEquals(response.errors, result.errors)
			assertEquals(response.errors!!.single(), result.message)
			assertNull(result.cause)
		}
	}

	@Test fun `many error results in error`() {
		val response = FakeResponse("test data", listOf("fake error 1", "fake error 2", "fake error 3"))

		assertThrows<QuickbookErrorsException> { response.throwErrorOrReturn { it.data } }.let { result ->
			assertEquals(response.errors, result.errors)
			response.errors!!.forEachIndexed { _, error ->
				assertTrue(result.message.orEmpty().contains(error))
			}
			assertNull(result.cause)
		}
	}
}
