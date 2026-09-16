package com.techlads.nabz.feature.home.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.techlads.nabz.core.designsystem.NabzColors
import com.techlads.nabz.core.designsystem.NabzTheme
import com.techlads.nabz.core.designsystem.component.IconCircle
import com.techlads.nabz.core.designsystem.component.RequestCard
import com.techlads.nabz.core.designsystem.component.SectionHeader
import com.techlads.nabz.core.designsystem.icon.NabzIcons
import com.techlads.nabz.core.model.SampleData
import com.techlads.nabz.core.model.UserProfile

@Composable
fun HomeScreen(
    profile: UserProfile = UserProfile.Empty,
    onOpenNotifications: () -> Unit = {},
    onOpenDonors: () -> Unit = {},
    onOpenRequest: () -> Unit = {},
    onOpenBanks: () -> Unit = {},
    onOpenRequestDetail: (String) -> Unit = {},
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(NabzColors.Cream)
            .verticalScroll(rememberScrollState()),
    ) {
        HomeHeader(profile, onOpenNotifications)
        Column(Modifier.padding(top = 16.dp)) {
            EligibilityCard()
            Spacer(Modifier.height(18.dp))
            QuickActions(
                onDonate = onOpenBanks,
                onRequest = onOpenRequest,
                onFind = onOpenDonors,
                onBanks = onOpenBanks,
            )
            Spacer(Modifier.height(22.dp))
            EmergencyBanner(onOpenRequest)
            Spacer(Modifier.height(22.dp))
            SectionHeader("Nearby requests", "See all", onOpenDonors)
            Spacer(Modifier.height(12.dp))
            Column(
                modifier = Modifier.padding(horizontal = 20.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                SampleData.requests.take(2).forEach { request ->
                    RequestCard(request, onClick = { onOpenRequestDetail(request.id) })
                }
            }
            Spacer(Modifier.height(28.dp))
        }
    }
}

@Composable
private fun HomeHeader(profile: UserProfile, onOpenNotifications: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(NabzColors.Crimson)
            .statusBarsPadding()
            .padding(horizontal = 20.dp, vertical = 18.dp),
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(Modifier.weight(1f)) {
                Text("Good afternoon", style = MaterialTheme.typography.bodyMedium, color = NabzColors.Surface.copy(alpha = 0.8f))
                Text(profile.displayName, style = MaterialTheme.typography.headlineSmall, color = NabzColors.Surface)
            }
            IconCircle(
                icon = NabzIcons.Bell,
                onClick = onOpenNotifications,
                tint = NabzColors.Surface,
                background = NabzColors.Surface.copy(alpha = 0.16f),
            )
        }
        Spacer(Modifier.height(16.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(NabzIcons.Pin, contentDescription = null, tint = NabzColors.Surface, modifier = Modifier.size(16.dp))
            Spacer(Modifier.width(6.dp))
            Text(profile.locationLabel, style = MaterialTheme.typography.labelLarge, color = NabzColors.Surface)
            Spacer(Modifier.weight(1f))
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .background(NabzColors.Surface.copy(alpha = 0.16f))
                    .padding(horizontal = 12.dp, vertical = 6.dp),
            ) {
                Text("${profile.bloodType} donor", color = NabzColors.Surface, style = MaterialTheme.typography.labelLarge)
            }
        }
    }
}

@Composable
private fun EligibilityCard() {
    Column(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(NabzColors.Surface)
            .padding(16.dp),
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(Modifier.weight(1f)) {
                Text("Ready to donate", style = MaterialTheme.typography.titleMedium)
                Text("Last donation 11 weeks ago", style = MaterialTheme.typography.bodySmall, color = NabzColors.Muted)
            }
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .background(NabzColors.SuccessSoft)
                    .padding(horizontal = 10.dp, vertical = 4.dp),
            ) {
                Text("Eligible", color = NabzColors.Success, style = MaterialTheme.typography.labelMedium)
            }
        }
        Spacer(Modifier.height(12.dp))
        LinearProgressIndicator(
            progress = { 0.92f },
            modifier = Modifier.fillMaxWidth().height(8.dp).clip(CircleShape),
            color = NabzColors.Crimson,
            trackColor = NabzColors.Rose,
            strokeCap = StrokeCap.Round,
        )
        Spacer(Modifier.height(8.dp))
        Text("12-week wait almost complete · 4 days left", style = MaterialTheme.typography.bodySmall, color = NabzColors.Muted)
    }
}

@Composable
private fun QuickActions(
    onDonate: () -> Unit,
    onRequest: () -> Unit,
    onFind: () -> Unit,
    onBanks: () -> Unit,
) {
    Column(Modifier.padding(horizontal = 20.dp)) {
        Text("Quick actions", style = MaterialTheme.typography.titleMedium)
        Spacer(Modifier.height(12.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            ActionTile("Donate", "Book a slot", NabzIcons.Heart, Modifier.weight(1f), onDonate)
            ActionTile("Request", "Need blood", NabzIcons.Drop, Modifier.weight(1f), onRequest)
        }
        Spacer(Modifier.height(10.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            ActionTile("Find donor", "Nearby matches", NabzIcons.Search, Modifier.weight(1f), onFind)
            ActionTile("Blood banks", "Stock nearby", NabzIcons.Hospital, Modifier.weight(1f), onBanks)
        }
    }
}

@Composable
private fun ActionTile(
    title: String,
    subtitle: String,
    icon: ImageVector,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(18.dp))
            .background(NabzColors.Surface)
            .clickable(onClick = onClick)
            .padding(14.dp),
    ) {
        Box(
            modifier = Modifier.size(36.dp).clip(RoundedCornerShape(10.dp)).background(NabzColors.Rose),
            contentAlignment = Alignment.Center,
        ) {
            Icon(icon, contentDescription = null, tint = NabzColors.Crimson, modifier = Modifier.size(18.dp))
        }
        Spacer(Modifier.height(12.dp))
        Text(title, style = MaterialTheme.typography.titleSmall)
        Text(subtitle, style = MaterialTheme.typography.bodySmall, color = NabzColors.Muted)
    }
}

@Composable
private fun EmergencyBanner(onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(18.dp))
            .background(NabzColors.Wine)
            .clickable(onClick = onClick)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(Modifier.weight(1f)) {
            Text("Need blood urgently?", style = MaterialTheme.typography.titleMedium, color = NabzColors.Surface)
            Text("Alert matching donors within 10 km", style = MaterialTheme.typography.bodySmall, color = NabzColors.Surface.copy(alpha = 0.8f))
        }
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .background(NabzColors.Surface)
                .padding(horizontal = 12.dp, vertical = 8.dp),
        ) {
            Text("SOS", color = NabzColors.Crimson, style = MaterialTheme.typography.labelLarge)
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    NabzTheme { HomeScreen() }
}
