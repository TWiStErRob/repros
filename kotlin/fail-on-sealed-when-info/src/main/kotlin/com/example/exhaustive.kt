package com.example

inline val <T> T.exhaustive: T
	get() = this

// region enum class
enum class EnumClass {
	First,
	Second,
	;
}

fun nonExhaustiveEnum(enumClass: EnumClass) {
	when (enumClass) {
		EnumClass.First -> doSomething()
	} // warning
}

fun exhaustiveEnum(enumClass: EnumClass) =
	when (enumClass) {
		EnumClass.First -> doSomething()
		EnumClass.Second -> doSomethingElse()
	} // ok, or compile error when case missing

fun nonExhaustiveEnumForced(enumClass: EnumClass) {
	when (enumClass) {
		EnumClass.First -> doSomething()
		EnumClass.Second -> doSomethingElse()
	}.exhaustive // ok, or compile error when case missing
}
// endregion

// region sealed class
sealed class SealedClass {
	object First : SealedClass()
	object Second : SealedClass()
}

fun nonExhaustiveSealedInstance(sealedClass: SealedClass) {
	when (sealedClass) {
		is SealedClass.First -> doSomething()
	} // should be flagged as not exhaustive (info is there), workaround targeting this
}

fun exhaustiveSealedInstance(sealedClass: SealedClass) =
	when (sealedClass) {
		is SealedClass.First -> doSomething()
		is SealedClass.Second -> doSomethingElse()
	} // ok, or compile error when case missing

fun nonExhaustiveSealedInstanceForced(sealedClass: SealedClass) {
	when (sealedClass) {
		is SealedClass.First -> doSomething()
		is SealedClass.Second -> doSomethingElse()
	}.exhaustive // ok, or compile error when case missing
}

fun nonExhaustiveSealedObject(sealedClass: SealedClass) {
	when (sealedClass) {
		SealedClass.First -> doSomething()
	} // should be flagged as not exhaustive (info is there), workaround targeting this
}

fun exhaustiveSealedObject(sealedClass: SealedClass) =
	when (sealedClass) {
		SealedClass.First -> doSomething()
		SealedClass.Second -> doSomethingElse()
	} // ok, or compile error when case missing

fun nonExhaustiveSealedObjectForced(sealedClass: SealedClass) {
	when (sealedClass) {
		SealedClass.First -> doSomething()
		SealedClass.Second -> doSomethingElse()
	}.exhaustive // ok, or compile error when case missing
}
// endregion

private fun doSomething() {}
private fun doSomethingElse() {}
