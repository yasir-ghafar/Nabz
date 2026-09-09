package com.techlads.nabz.feature.notifications.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
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
import com.techlads.nabz.core.designsystem.component.ScreenTopBar
import com.techlads.nabz.core.designsystem.icon.NabzIcons

@Composable
fun NotificationsScreen(onBack: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(NabzColors.Cream)
            .statusBarsPadding(),
    ) {
        ScreenTopBar("Alerts", onBack)
        Column(Modifier.padding(horizontal = 20.dp)) {
            Notice(NabzIcons.Drop, "O- needed at Shaukat Khanum", "12 min ago · 1.8 km")
            Spacer(Modifier.height(10.dp))
            Notice(NabzIcons.Heart, "You’re eligible to donate again", "Yesterday")
            Spacer(Modifier.height(10.dp))
            Notice(NabzIcons.Hospital, "Fatimid Foundation restocked O+", "2 days ago")
        }
    }
}

@Composable
private fun Notice(icon: ImageVector, title: String, meta: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(NabzColors.Surface)
            .padding(14.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            icon,
            contentDescription = null,
            tint = NabzColors.Crimson,
            modifier = Modifier
                .clip(CircleShape)
                .background(NabzColors.Rose)
                .padding(10.dp),
        )
        Spacer(Modifier.width(12.dp))
        Column {
            Text(title, style = MaterialTheme.typography.titleSmall)
            Text(meta, style = MaterialTheme.typography.bodySmall, color = NabzColors.Muted)
        }
    }
}
