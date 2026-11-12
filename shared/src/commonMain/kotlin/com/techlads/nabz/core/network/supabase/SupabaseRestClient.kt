package com.techlads.nabz.core.network.supabase

import com.techlads.nabz.core.network.ApiConfig
import com.techlads.nabz.core.network.HttpClientFactory
import com.techlads.nabz.core.network.NetworkError
import com.techlads.nabz.core.util.Result
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.patch
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import io.ktor.http.isSuccess
import kotlinx.serialization.SerializationException

/**
 * Thin Supabase PostgREST client used by feature repositories.
 *
 * Paths are relative to [ApiConfig.restBaseUrl] (e.g. `"blood_requests"`).
 * Query filters follow PostgREST syntax (`eq.`, `in.`, etc.).
 */
class SupabaseRestClient(
    val httpClient: HttpClient,
    val config: ApiConfig = ApiConfig.Default,
) {
    suspend inline fun <reified T> get(
        table: String,
        crossinline query: QueryBuilder.() -> Unit = {},
    ): Result<T> = safeCall {
        httpClient.get(table) {
            QueryBuilder().apply(query).applyTo(this)
        }.parseBody()
    }

    suspend inline fun <reified T, reified B> post(
        table: String,
        body: B,
    ): Result<T> = safeCall {
        httpClient.post(table) {
            setBody(body)
        }.parseBody()
    }

    suspend inline fun <reified T, reified B> patch(
        table: String,
        body: B,
        crossinline query: QueryBuilder.() -> Unit = {},
    ): Result<T> = safeCall {
        httpClient.patch(table) {
            QueryBuilder().apply(query).applyTo(this)
            setBody(body)
        }.parseBody()
    }

    suspend inline fun <reified T> delete(
        table: String,
        crossinline query: QueryBuilder.() -> Unit = {},
    ): Result<T> = safeCall {
        httpClient.delete(table) {
            QueryBuilder().apply(query).applyTo(this)
        }.parseBody()
    }

    suspend inline fun <reified T> safeCall(crossinline block: suspend () -> T): Result<T> =
        try {
            Result.Success(block())
        } catch (error: NetworkError) {
            Result.Error(error.message ?: "Request failed", error)
        } catch (error: SerializationException) {
            Result.Error(
                error.message ?: "Failed to parse response",
                NetworkError.Serialization(error.message ?: "", error),
            )
        } catch (error: Throwable) {
            Result.Error(
                error.message ?: "Unexpected error",
                NetworkError.Unknown(cause = error),
            )
        }

    suspend inline fun <reified T> HttpResponse.parseBody(): T {
        if (!status.isSuccess()) {
            val errorBody = runCatching { bodyAsText() }.getOrElse { "" }
            throw NetworkError.Http(
                statusCode = status.value,
                message = errorBody.ifBlank { "HTTP ${status.value}" },
            )
        }
        if (status == HttpStatusCode.NoContent) {
            @Suppress("UNCHECKED_CAST")
            return Unit as T
        }
        return body()
    }

    fun close() {
        httpClient.close()
    }

    companion object {
        fun create(
            config: ApiConfig = ApiConfig.Default,
            accessTokenProvider: () -> String? = { null },
        ): SupabaseRestClient = SupabaseRestClient(
            httpClient = HttpClientFactory.create(config, accessTokenProvider),
            config = config,
        )
    }
}

/**
 * Builds PostgREST query parameters for a request.
 *
 * Example:
 * ```
 * eq("blood_type", "O+")
 * order("created_at", ascending = false)
 * limit(20)
 * ```
 */
class QueryBuilder {
    private val params = mutableListOf<Pair<String, String>>()

    fun eq(column: String, value: String) = apply { params += column to "eq.$value" }
    fun neq(column: String, value: String) = apply { params += column to "neq.$value" }
    fun gt(column: String, value: String) = apply { params += column to "gt.$value" }
    fun gte(column: String, value: String) = apply { params += column to "gte.$value" }
    fun lt(column: String, value: String) = apply { params += column to "lt.$value" }
    fun lte(column: String, value: String) = apply { params += column to "lte.$value" }
    fun like(column: String, pattern: String) = apply { params += column to "like.$pattern" }
    fun ilike(column: String, pattern: String) = apply { params += column to "ilike.$pattern" }
    fun `in`(column: String, values: Collection<String>) =
        apply { params += column to "in.(${values.joinToString(",")})" }

    fun select(columns: String) = apply { params += "select" to columns }
    fun limit(count: Int) = apply { params += "limit" to count.toString() }
    fun offset(count: Int) = apply { params += "offset" to count.toString() }
    fun order(column: String, ascending: Boolean = true) = apply {
        params += "order" to "$column.${if (ascending) "asc" else "desc"}"
    }

    fun applyTo(builder: HttpRequestBuilder) {
        params.forEach { (key, value) ->
            builder.parameter(key, value)
        }
    }
}
