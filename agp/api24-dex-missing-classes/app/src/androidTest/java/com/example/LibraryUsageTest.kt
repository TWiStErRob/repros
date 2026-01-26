package com.example

import com.example.ExampleClass
import org.junit.Assert.assertEquals
import org.junit.Test

class LibraryUsageTest {
    @Test
    fun usesLibraryClass() {
        assertEquals("ExampleClass", ExampleClass::class.simpleName)
    }
}
