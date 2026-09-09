package com.techlads.nabz.app.di

import com.techlads.nabz.feature.home.data.GreetingRepository
import com.techlads.nabz.feature.home.domain.Greeting

/**
 * Simple manual DI graph. Replace with Koin/Kodein when dependencies grow.
 */
object AppContainer {
    val greeting: Greeting by lazy { Greeting() }
    val greetingRepository: GreetingRepository by lazy { GreetingRepository(greeting) }
}
