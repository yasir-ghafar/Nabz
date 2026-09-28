package com.techlads.nabz.core.network.supabase

/**
 * PostgREST table names. Keep in sync with the Supabase schema.
 */
object SupabaseTables {
    const val USERS = "users"
    const val USER_PROFILES = "user_profiles"
    const val BLOOD_REQUESTS = "blood_requests"
    const val REQUEST_MATCHES = "request_matches"
    const val DONATIONS = "donations"
    const val BLOOD_BANKS = "blood_banks"
    const val BLOOD_BANK_STOCK = "blood_bank_stock"
    const val SAVED_BLOOD_BANKS = "saved_blood_banks"
    const val NOTIFICATIONS = "notifications"
}
