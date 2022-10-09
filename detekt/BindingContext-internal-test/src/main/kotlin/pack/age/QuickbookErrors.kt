package pack.age

internal interface QuickbookErrors {
	val errors: List<String>?
}

internal fun <T : QuickbookErrors, R> T.throwErrorOrReturn(block: (T) -> R): R {
	val errors = this.errors
	if (!errors.isNullOrEmpty()) throw QuickbookErrorsException(errors)
	return block(this)
}

data class QuickbookErrorsException(
	val errors: List<String>
) : Exception(errors.joinToString(separator = "\n"))
