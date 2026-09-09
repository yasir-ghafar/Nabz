package com.techlads.nabz.core.model

data class Donor(
    val id: String,
    val name: String,
    val bloodType: String,
    val area: String,
    val city: String,
    val distanceKm: Double,
    val lastDonated: String,
    val available: Boolean,
    val donations: Int,
    val phone: String,
    val verified: Boolean,
)

data class BloodRequest(
    val id: String,
    val patient: String,
    val bloodType: String,
    val hospital: String,
    val city: String,
    val units: Int,
    val urgency: String,
    val postedAgo: String,
    val distanceKm: Double,
)

data class BloodBank(
    val id: String,
    val name: String,
    val area: String,
    val distanceKm: Double,
    val openUntil: String,
    val typesInStock: List<String>,
)

object SampleData {
    val bloodTypes = listOf("A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-")

    val donors = listOf(
        Donor("1", "Hamza Ali", "B+", "Gulberg", "Lahore", 1.2, "11 weeks ago", true, 14, "0300 1111111", true),
        Donor("2", "Fatima Noor", "O+", "F-10", "Islamabad", 2.4, "4 months ago", true, 9, "0300 2222222", true),
        Donor("3", "Omar Sheikh", "A-", "Clifton", "Karachi", 3.1, "6 weeks ago", false, 21, "0300 3333333", true),
        Donor("4", "Zainab Malik", "O-", "Saddar", "Rawalpindi", 4.8, "3 months ago", true, 6, "0300 4444444", false),
        Donor("5", "Bilal Raza", "AB+", "DHA Phase 5", "Lahore", 5.0, "8 weeks ago", true, 11, "0300 5555555", true),
    )

    val requests = listOf(
        BloodRequest("r1", "Ahmed Raza", "O-", "Shaukat Khanum", "Lahore", 3, "Critical", "12 min ago", 1.8),
        BloodRequest("r2", "Sara Iqbal", "B+", "Services Hospital", "Lahore", 2, "Urgent", "1 hr ago", 3.4),
        BloodRequest("r3", "Hassan Khan", "A+", "PIMS", "Islamabad", 1, "Needed today", "3 hr ago", 6.1),
    )

    val banks = listOf(
        BloodBank("b1", "Fatimid Foundation", "Garden Town", 1.4, "Open until 8:00 PM", listOf("O+", "O-", "B+")),
        BloodBank("b2", "Sundas Foundation", "Model Town", 2.7, "Open until 9:00 PM", listOf("A+", "AB+", "O+")),
        BloodBank("b3", "Hussaini Blood Bank", "Johar Town", 4.1, "Open 24 hours", listOf("A-", "B-", "O-")),
    )
}
