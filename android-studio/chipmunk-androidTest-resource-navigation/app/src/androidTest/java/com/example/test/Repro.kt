package com.example.test

import org.junit.Assert.assertNotEquals
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.ext.junit.runners.AndroidJUnit4

import com.example.app.R as AppR
import com.example.app.test.R as TestR
import com.example.lib.R as LibR

@RunWith(AndroidJUnit4::class)
class Repro {

    @Test
    fun test() {
        // Compilation: green = IDE recognizes the class/field, and shows this correctly.
        // Compilation: red = IDE doesn't see the class/field, shows an error stripe for import an usage.
        // Navigation: Cmd/Ctrl+Click to navigate to definition of id or string. Should open layout or strings.xml.

        // 4.2.2 Compilation green, Navigation works
        // 7.x Compilation green, Navigation works
        assertNotEquals(0, AppR.id.view_in_app)
        assertNotEquals(0, AppR.string.text_in_app)

        // 4.2.2 Compilation green, Not navigable: nothing happens
        // 7.x Compilation green, Not navigable: nothing happens
        assertNotEquals(0, LibR.id.view_in_lib)
        // Note: collapsing the string shows "..." rather than the content of the string.
        assertNotEquals(0, LibR.string.text_in_lib)

        // 4.2.2 Compilation green, Not navigable: nothing happens
        // 7.x Compilation red on view_in_lib/text_in_lib, Not navigable: "Cannot find declaration to go to" (consequence of red)
        assertNotEquals(0, AppR.id.view_in_lib)
        assertNotEquals(0, AppR.string.text_in_lib)

        // 4.2.2 Compilation red on TestR, Not navigable: "Cannot find declaration to go to" (consequence of red)
        // 7.x Compilation green, Not navigable: nothing happens
        // Note: collapsing the string shows "..." rather than the content of the string.
        assertNotEquals(0, TestR.string.text_in_test)
    }
}
