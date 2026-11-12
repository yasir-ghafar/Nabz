package com.techlads.nabz.core.network

sealed class NetworkError(
    message: String,
    cause: Throwable? = null,
) : Exception(message, cause) {
    class Http(
        val statusCode: Int,
        message: String,
        cause: Throwable? = null,
    ) : NetworkError(message, cause)

    class Serialization(
        message: String,
        cause: Throwable? = null,
    ) : NetworkError(message, cause)

    class Connectivity(
        message: String = "Unable to reach the server",
        cause: Throwable? = null,
    ) : NetworkError(message, cause)

    class Unknown(
        message: String = "Unexpected network error",
        cause: Throwable? = null,
    ) : NetworkError(message, cause)
}
