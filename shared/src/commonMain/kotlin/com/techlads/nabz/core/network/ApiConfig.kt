package com.techlads.nabz.core.network

/**
 * Supabase project configuration.
 *
 * Replace [supabaseUrl] and [supabaseAnonKey] with values from the Supabase
 * dashboard (Project Settings → API) before hitting a real backend.
 *
 * REST base: `{supabaseUrl}/rest/v1`
 * Auth base: `{supabaseUrl}/auth/v1`
 */
data class ApiConfig(
    val supabaseUrl: String = PLACEHOLDER_SUPABASE_URL,
    val supabaseAnonKey: String = PLACEHOLDER_SUPABASE_ANON_KEY,
    val enableLogging: Boolean = true,
) {
    val restBaseUrl: String
        get() = "${supabaseUrl.trimEnd('/')}/rest/v1"

    val authBaseUrl: String
        get() = "${supabaseUrl.trimEnd('/')}/auth/v1"

    companion object {
        const val PLACEHOLDER_SUPABASE_URL = "https://YOUR_PROJECT_REF.supabase.co"
        const val PLACEHOLDER_SUPABASE_ANON_KEY = "YOUR_SUPABASE_ANON_KEY"

        val Default = ApiConfig()
    }
}
