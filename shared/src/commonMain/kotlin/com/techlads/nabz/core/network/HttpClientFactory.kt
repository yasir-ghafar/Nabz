package com.techlads.nabz.core.network

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

/**
 * Creates a shared Ktor [HttpClient] configured for Supabase REST.
 * Engine is provided per platform via [createPlatformHttpClient].
 */
object HttpClientFactory {
    fun create(
        config: ApiConfig = ApiConfig.Default,
        accessTokenProvider: () -> String? = { null },
    ): HttpClient = createPlatformHttpClient {
        expectSuccess = false

        install(ContentNegotiation) {
            json(defaultJson)
        }

        install(HttpTimeout) {
            connectTimeoutMillis = 15_000
            requestTimeoutMillis = 30_000
            socketTimeoutMillis = 30_000
        }

        if (config.enableLogging) {
            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        println("[NabzHttp] $message")
                    }
                }
                level = LogLevel.INFO
            }
        }

        defaultRequest {
            url(config.restBaseUrl.trimEnd('/') + "/")
            contentType(ContentType.Application.Json)
            header("apikey", config.supabaseAnonKey)
            val bearer = accessTokenProvider() ?: config.supabaseAnonKey
            header(HttpHeaders.Authorization, "Bearer $bearer")
            header("Prefer", "return=representation")
        }
    }

    val defaultJson: Json = Json {
        ignoreUnknownKeys = true
        isLenient = true
        encodeDefaults = true
        prettyPrint = false
        explicitNulls = false
    }
}

/**
 * Platform HttpClient (OkHttp on Android, Darwin on iOS).
 */
expect fun createPlatformHttpClient(
    block: HttpClientConfig<*>.() -> Unit = {},
): HttpClient
