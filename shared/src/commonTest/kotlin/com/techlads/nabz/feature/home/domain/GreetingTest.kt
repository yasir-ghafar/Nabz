package com.techlads.nabz.feature.home.domain

import kotlin.test.Test
import kotlin.test.assertEquals

class GreetingTest {

    @Test
    fun sayHello_formatsMessage() {
        assertEquals("Hello, Nabz!", sayHello("Nabz"))
    }
}
