package com.example

import com.example.app.R as AppR
import com.example.lib.R as LibR

class Verify {

    fun test() {
        println(AppR.id.view_in_app)
        println(AppR.string.text_in_app)

        println(AppR.id.view_in_lib)
        println(AppR.string.text_in_lib)

        println(LibR.id.view_in_lib)
        println(LibR.string.text_in_lib)
    }
}
