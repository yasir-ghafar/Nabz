package com.techlads.nabz.core.model

data class UserProfile(
    val name: String,
    val phone: String,
    val city: String,
    val area: String,
    val bloodType: String,
) {
    val displayName: String get() = name.ifBlank { "Guest" }

    val locationLabel: String
        get() = listOf(area, city)
            .filter { it.isNotBlank() }
            .joinToString(", ")
            .ifBlank { "Add your city" }

    companion object {
        val Empty = UserProfile(
            name = "",
            phone = "",
            city = "",
            area = "",
            bloodType = "O+",
        )
    }
}
