package com.techlads.nabz.feature.donors.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.techlads.nabz.core.designsystem.NabzColors
import com.techlads.nabz.core.designsystem.component.BloodTypeBadge
import com.techlads.nabz.core.designsystem.component.InitialsAvatar
import com.techlads.nabz.core.designsystem.component.NabzGhostButton
import com.techlads.nabz.core.designsystem.component.NabzPrimaryButton
import com.techlads.nabz.core.designsystem.component.ScreenTopBar
import com.techlads.nabz.core.model.Donor

@Composable
fun DonorProfileScreen(donor: Donor, onBack: () -> Unit, onCall: () -> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(NabzColors.Cream)
            .statusBarsPadding(),
    ) {
        ScreenTopBar(title = "Donor", onBack = onBack)
        Column(
            modifier = Modifier.padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(Modifier.height(8.dp))
            InitialsAvatar(donor.name, size = 84.dp)
            Spacer(Modifier.height(12.dp))
            Text(donor.name, style = MaterialTheme.typography.headlineSmall)
            Text(
                "${donor.area}, ${donor.city} · ${donor.distanceKm} km away",
                style = MaterialTheme.typography.bodyMedium,
                color = NabzColors.Muted,
            )
            Spacer(Modifier.height(16.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                StatCard("Type", donor.bloodType, Modifier.weight(1f), highlight = true)
                StatCard("Donations", donor.donations.toString(), Modifier.weight(1f))
                StatCard("Status", if (donor.available) "Ready" else "Resting", Modifier.weight(1f))
            }
            Spacer(Modifier.height(18.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(18.dp))
                    .background(NabzColors.Surface)
                    .padding(16.dp),
            ) {
                InfoRow("Last donated", donor.lastDonated)
                InfoRow("Verified", if (donor.verified) "ID checked" else "Pending")
                InfoRow("Phone", donor.phone)
            }
            Spacer(Modifier.height(20.dp))
            NabzPrimaryButton("Call donor", onCall)
            Spacer(Modifier.height(10.dp))
            NabzGhostButton("Send request", onCall)
        }
    }
}

@Composable
private fun StatCard(
    label: String,
    value: String,
    modifier: Modifier = Modifier,
    highlight: Boolean = false,
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(if (highlight) NabzColors.Rose else NabzColors.Surface)
            .padding(14.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        if (highlight) {
            BloodTypeBadge(value, size = 40.dp)
            Spacer(Modifier.height(8.dp))
        } else {
            Text(value, style = MaterialTheme.typography.titleLarge, color = NabzColors.Ink)
        }
        Text(label, style = MaterialTheme.typography.labelMedium, color = NabzColors.Muted)
    }
}

@Composable
private fun InfoRow(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(label, style = MaterialTheme.typography.bodyMedium, color = NabzColors.Muted, modifier = Modifier.weight(1f))
        Text(value, style = MaterialTheme.typography.titleSmall)
    }
}
