package com.techlads.nabz.feature.home.domain

import com.techlads.nabz.platform.getPlatform

class Greeting {
    private val platform = getPlatform()

    fun greet(): String = sayHello(platform.name)
}
