package com.techlads.nabz.feature.auth.ui

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.techlads.nabz.core.designsystem.NabzColors
import com.techlads.nabz.core.designsystem.component.NabzGhostButton
import com.techlads.nabz.core.designsystem.component.NabzPrimaryButton
import com.techlads.nabz.core.designsystem.component.NabzTextField
import com.techlads.nabz.core.designsystem.component.PulseLogo


@Composable
fun SignInScreen(
    onSignedIn: (phone: String) -> Unit,
    onCreateProfile: () -> Unit = {},
    onGuest: () -> Unit,
    onRegister:() -> Unit = {},
) {
    var phone by remember { mutableStateOf("") }
    var otp by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
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
        //NabzTextField(otp, { otp = it }, "One-time code")
        NabzTextField(password, { password = it }, "Password", isPassword = true)
        Spacer(Modifier.height(24.dp))
        NabzPrimaryButton("Continue", onClick = { onSignedIn(phone) })
        Spacer(Modifier.height(12.dp))
        NabzGhostButton("Continue as guest", onClick = { onGuest() })
        Spacer(Modifier.weight(1f))
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text("New to Nabz? ", color = NabzColors.Muted, style = MaterialTheme.typography.bodyMedium)
            Text(
                "Register",
                color = NabzColors.Crimson,
                style = MaterialTheme.typography.labelLarge,
                modifier = Modifier.clickable(onClick = onRegister),
            )
        }
        Spacer(Modifier.height(8.dp))
    }
}

