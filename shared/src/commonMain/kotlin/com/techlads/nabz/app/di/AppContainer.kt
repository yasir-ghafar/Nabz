package com.techlads.nabz.app.di

import com.techlads.nabz.core.network.ApiConfig
import com.techlads.nabz.core.network.HttpClientFactory
import com.techlads.nabz.core.network.supabase.SupabaseRestClient
import com.techlads.nabz.feature.home.data.GreetingRepository
import com.techlads.nabz.feature.home.domain.Greeting
import io.ktor.client.HttpClient

/**
 * Simple manual DI graph. Replace with Koin/Kodein when dependencies grow.
 */
object AppContainer {
    val apiConfig: ApiConfig by lazy { ApiConfig.Default }

    /**
     * Swap for a real session token provider once auth is wired.
     */
    private var accessToken: String? = null

    fun updateAccessToken(token: String?) {
        accessToken = token
    }

    val httpClient: HttpClient by lazy {
        HttpClientFactory.create(
            config = apiConfig,
            accessTokenProvider = { accessToken },
        )
    }

    val supabase: SupabaseRestClient by lazy {
        SupabaseRestClient(httpClient = httpClient, config = apiConfig)
    }

    val greeting: Greeting by lazy { Greeting() }
    val greetingRepository: GreetingRepository by lazy { GreetingRepository(greeting) }
}
