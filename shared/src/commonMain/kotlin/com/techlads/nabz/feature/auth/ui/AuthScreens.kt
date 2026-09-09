package com.techlads.nabz.feature.auth.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.techlads.nabz.core.designsystem.NabzColors
import com.techlads.nabz.core.designsystem.component.NabzGhostButton
import com.techlads.nabz.core.designsystem.component.NabzPrimaryButton
import com.techlads.nabz.core.designsystem.component.NabzTextField
import com.techlads.nabz.core.designsystem.component.PulseLogo
import com.techlads.nabz.core.designsystem.icon.NabzIcons

@Composable
fun WelcomeScreen(onContinue: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(NabzColors.Cream)
            .statusBarsPadding()
            .padding(24.dp),
    ) {
        PulseLogo(Modifier.size(56.dp), dropColor = NabzColors.Crimson, pulseColor = NabzColors.Surface)
        Spacer(Modifier.height(20.dp))
        Text("How will you use Nabz?", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(8.dp))
        Text(
            "You can switch later. Most people do both — donate when eligible, request when family needs blood.",
            style = MaterialTheme.typography.bodyMedium,
            color = NabzColors.Muted,
        )
        Spacer(Modifier.height(28.dp))
        RoleCard(
            title = "I can donate",
            subtitle = "Share your type, get alerts for nearby requests, book a slot.",
            icon = NabzIcons.Heart,
            onClick = onContinue,
        )
        Spacer(Modifier.height(12.dp))
        RoleCard(
            title = "I need blood",
            subtitle = "Find matching donors fast or post an emergency request.",
            icon = NabzIcons.Drop,
            onClick = onContinue,
        )
        Spacer(Modifier.weight(1f))
        Text(
            "You can donate and request from the same profile.",
            style = MaterialTheme.typography.bodySmall,
            color = NabzColors.Muted,
        )
    }
}

@Composable
private fun RoleCard(
    title: String,
    subtitle: String,
    icon: ImageVector,
    onClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(NabzColors.Surface)
            .border(1.dp, NabzColors.Line, RoundedCornerShape(20.dp))
            .clickable(onClick = onClick)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier = Modifier.size(48.dp).clip(CircleShape).background(NabzColors.Rose),
            contentAlignment = Alignment.Center,
        ) {
            Icon(icon, contentDescription = null, tint = NabzColors.Crimson, modifier = Modifier.size(22.dp))
        }
        Spacer(Modifier.width(14.dp))
        Column(Modifier.weight(1f)) {
            Text(title, style = MaterialTheme.typography.titleMedium)
            Text(subtitle, style = MaterialTheme.typography.bodySmall, color = NabzColors.Muted)
        }
        Icon(NabzIcons.ArrowRight, contentDescription = null, tint = NabzColors.Muted, modifier = Modifier.size(18.dp))
    }
}

@Composable
fun SignInScreen(onSignedIn: () -> Unit) {
    var phone by remember { mutableStateOf("") }
    var otp by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(NabzColors.Cream)
            .statusBarsPadding()
            .padding(24.dp),
    ) {
        PulseLogo(Modifier.size(48.dp), dropColor = NabzColors.Crimson, pulseColor = NabzColors.Surface)
        Spacer(Modifier.height(20.dp))
        Text("Welcome back", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(6.dp))
        Text("Sign in with your phone. We’ll never share it with other donors.", style = MaterialTheme.typography.bodyMedium, color = NabzColors.Muted)
        Spacer(Modifier.height(28.dp))
        NabzTextField(phone, { phone = it }, "Phone number")
        Spacer(Modifier.height(12.dp))
        NabzTextField(otp, { otp = it }, "One-time code")
        Spacer(Modifier.height(24.dp))
        NabzPrimaryButton("Continue", onSignedIn)
        Spacer(Modifier.height(12.dp))
        NabzGhostButton("Continue as guest", onSignedIn)
        Spacer(Modifier.weight(1f))
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text("New to Nabz? ", color = NabzColors.Muted, style = MaterialTheme.typography.bodyMedium)
            Text("Create profile", color = NabzColors.Crimson, style = MaterialTheme.typography.labelLarge, modifier = Modifier.clickable(onClick = onSignedIn))
        }
        Spacer(Modifier.height(8.dp))
    }
}
