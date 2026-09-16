package com.techlads.nabz.feature.profile.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.techlads.nabz.core.designsystem.NabzColors
import com.techlads.nabz.core.designsystem.component.BloodTypeChip
import com.techlads.nabz.core.designsystem.component.InitialsAvatar
import com.techlads.nabz.core.designsystem.component.NabzGhostButton
import com.techlads.nabz.core.designsystem.component.NabzPrimaryButton
import com.techlads.nabz.core.designsystem.component.NabzTextField
import com.techlads.nabz.core.designsystem.component.ScreenTopBar
import com.techlads.nabz.core.model.SampleData
import com.techlads.nabz.core.model.UserProfile

@Composable
fun EditProfileScreen(
    profile: UserProfile,
    isOnboarding: Boolean,
    onSave: (UserProfile) -> Unit,
    onBack: () -> Unit = {},
    onSkip: () -> Unit = {},
) {
    var name by remember(profile) { mutableStateOf(profile.name) }
    var phone by remember(profile) { mutableStateOf(profile.phone) }
    var city by remember(profile) { mutableStateOf(profile.city) }
    var area by remember(profile) { mutableStateOf(profile.area) }
    var bloodType by remember(profile) { mutableStateOf(profile.bloodType) }
    val title = if (isOnboarding) "Add your details" else "Edit profile"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(NabzColors.Cream)
            .statusBarsPadding(),
    ) {
        if (isOnboarding) {
            Text(
                title,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 16.dp),
            )
        } else {
            ScreenTopBar(title, onBack)
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            InitialsAvatar(name.ifBlank { "Guest" }, size = 72.dp)
            Spacer(Modifier.height(8.dp))
            Text(
                if (isOnboarding) {
                    "Donors and hospitals use this to match you nearby."
                } else {
                    "Update how you appear to nearby requests."
                },
                style = MaterialTheme.typography.bodyMedium,
                color = NabzColors.Muted,
                modifier = Modifier.fillMaxWidth(),
            )
            Spacer(Modifier.height(18.dp))
            NabzTextField(name, { name = it }, "Full name")
            Spacer(Modifier.height(12.dp))
            NabzTextField(phone, { phone = it }, "Phone number")
            Spacer(Modifier.height(12.dp))
            NabzTextField(city, { city = it }, "City")
            Spacer(Modifier.height(12.dp))
            NabzTextField(area, { area = it }, "Area")
            Spacer(Modifier.height(16.dp))
            Text(
                "Blood type",
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.fillMaxWidth(),
            )
            Spacer(Modifier.height(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                SampleData.bloodTypes.forEach { option ->
                    BloodTypeChip(option, selected = option == bloodType, onClick = { bloodType = option })
                }
            }
            Spacer(Modifier.height(24.dp))
        }
        Column(Modifier.padding(20.dp)) {
            NabzPrimaryButton(
                text = "Save profile",
                onClick = {
                    onSave(
                        UserProfile(
                            name = name.trim(),
                            phone = phone.trim(),
                            city = city.trim(),
                            area = area.trim(),
                            bloodType = bloodType,
                        ),
                    )
                },
            )
            if (isOnboarding) {
                Spacer(Modifier.height(10.dp))
                NabzGhostButton("Skip for now", onSkip)
            }
        }
    }
}
