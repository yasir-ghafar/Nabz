package com.techlads.nabz.feature.profile.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.techlads.nabz.core.designsystem.NabzColors
import com.techlads.nabz.core.designsystem.component.BloodTypeBadge
import com.techlads.nabz.core.designsystem.component.InitialsAvatar
import com.techlads.nabz.core.designsystem.icon.NabzIcons

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(NabzColors.Cream)
            .statusBarsPadding()
            .padding(horizontal = 20.dp),
    ) {
        Spacer(Modifier.height(12.dp))
        Text("Profile", style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(16.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp))
                .background(NabzColors.Surface)
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            InitialsAvatar("Ayesha Khan", size = 64.dp)
            Spacer(Modifier.width(14.dp))
            Column(Modifier.weight(1f)) {
                Text("Ayesha Khan", style = MaterialTheme.typography.titleLarge)
                Text("Gulberg, Lahore", style = MaterialTheme.typography.bodySmall, color = NabzColors.Muted)
            }
            BloodTypeBadge("O+")
        }
        Spacer(Modifier.height(12.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            ImpactStat("8", "Donations", Modifier.weight(1f))
            ImpactStat("24", "Lives reached", Modifier.weight(1f))
            ImpactStat("Eligible", "Status", Modifier.weight(1f))
        }
        Spacer(Modifier.height(18.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(18.dp))
                .background(NabzColors.Surface),
        ) {
            ProfileRow(NabzIcons.Calendar, "Donation history")
            ProfileRow(NabzIcons.Bell, "Alerts & requests")
            ProfileRow(NabzIcons.Shield, "Medical profile")
            ProfileRow(NabzIcons.Hospital, "Saved banks")
        }
    }
}

@Composable
private fun ImpactStat(value: String, label: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(NabzColors.Surface)
            .padding(14.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(value, style = MaterialTheme.typography.titleMedium, color = NabzColors.Crimson)
        Text(label, style = MaterialTheme.typography.labelMedium, color = NabzColors.Muted)
    }
}

@Composable
private fun ProfileRow(icon: ImageVector, title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { }
            .padding(horizontal = 16.dp, vertical = 14.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(icon, contentDescription = null, tint = NabzColors.Crimson, modifier = Modifier.padding(end = 12.dp))
        Text(title, style = MaterialTheme.typography.titleSmall, modifier = Modifier.weight(1f))
        Icon(NabzIcons.ArrowRight, contentDescription = null, tint = NabzColors.Muted)
    }
}
