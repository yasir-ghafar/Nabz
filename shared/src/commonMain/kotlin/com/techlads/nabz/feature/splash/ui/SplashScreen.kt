package com.techlads.nabz.feature.splash.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.techlads.nabz.core.designsystem.NabzColors
import com.techlads.nabz.core.designsystem.component.PulseLogo
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onFinished: () -> Unit) {
    LaunchedEffect(Unit) {
        delay(1400)
        onFinished()
    }
    Box(
        modifier = Modifier.fillMaxSize().background(NabzColors.Crimson),
        contentAlignment = Alignment.Center,
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            PulseLogo(
                modifier = Modifier.size(96.dp),
                dropColor = NabzColors.Surface,
                pulseColor = NabzColors.Crimson,
            )
            Spacer(Modifier.height(20.dp))
            Text("Nabz", style = MaterialTheme.typography.displaySmall, color = NabzColors.Surface)
            Spacer(Modifier.height(6.dp))
            Text(
                "Every pulse can save a life",
                style = MaterialTheme.typography.bodyMedium,
                color = NabzColors.Surface.copy(alpha = 0.84f),
            )
        }
    }
}
