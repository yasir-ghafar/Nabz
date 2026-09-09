package com.techlads.nabz.feature.home.data

import com.techlads.nabz.feature.home.domain.Greeting

/**
 * Data layer entry for home. Expand with remote/local sources as features grow.
 */
class GreetingRepository(
    private val greeting: Greeting = Greeting(),
) {
    fun getGreeting(): String = greeting.greet()
}
