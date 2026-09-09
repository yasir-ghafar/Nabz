package com.techlads.nabz.feature.request.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import com.techlads.nabz.core.designsystem.component.NabzPrimaryButton
import com.techlads.nabz.core.designsystem.component.NabzTextField
import com.techlads.nabz.core.designsystem.component.PulseLogo
import com.techlads.nabz.core.designsystem.component.ScreenTopBar
import com.techlads.nabz.core.model.SampleData
import androidx.compose.foundation.layout.size

@Composable
fun RequestBloodScreen(onBack: () -> Unit, onSubmitted: () -> Unit) {
    var patient by remember { mutableStateOf("Ahmed Raza") }
    var hospital by remember { mutableStateOf("Shaukat Khanum") }
    var units by remember { mutableStateOf("3") }
    var type by remember { mutableStateOf("O-") }
    var urgency by remember { mutableStateOf("Critical") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(NabzColors.Cream)
            .statusBarsPadding(),
    ) {
        ScreenTopBar("Request blood", onBack)
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp),
        ) {
            Text("We’ll alert compatible donors near the hospital.", style = MaterialTheme.typography.bodyMedium, color = NabzColors.Muted)
            Spacer(Modifier.height(18.dp))
            NabzTextField(patient, { patient = it }, "Patient name")
            Spacer(Modifier.height(12.dp))
            NabzTextField(hospital, { hospital = it }, "Hospital")
            Spacer(Modifier.height(12.dp))
            NabzTextField(units, { units = it }, "Units needed")
            Spacer(Modifier.height(16.dp))
            Text("Blood type", style = MaterialTheme.typography.titleSmall)
            Spacer(Modifier.height(8.dp))
            Row(
                modifier = Modifier.horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                SampleData.bloodTypes.forEach { option ->
                    BloodTypeChip(option, selected = option == type, onClick = { type = option })
                }
            }
            Spacer(Modifier.height(16.dp))
            Text("Urgency", style = MaterialTheme.typography.titleSmall)
            Spacer(Modifier.height(8.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                listOf("Needed today", "Urgent", "Critical").forEach { option ->
                    BloodTypeChip(option, selected = option == urgency, onClick = { urgency = option })
                }
            }
            Spacer(Modifier.height(24.dp))
        }
        Column(Modifier.padding(20.dp)) {
            NabzPrimaryButton("Send to matching donors", onSubmitted)
        }
    }
}

@Composable
fun RequestSentScreen(onDone: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(NabzColors.Cream)
            .statusBarsPadding()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        PulseLogo(Modifier.size(88.dp), dropColor = NabzColors.Crimson, pulseColor = NabzColors.Surface)
        Spacer(Modifier.height(20.dp))
        Text("Request sent", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(8.dp))
        Text(
            "12 O- donors within 10 km were notified. You’ll see responses here as they come in.",
            style = MaterialTheme.typography.bodyLarge,
            color = NabzColors.Muted,
        )
        Spacer(Modifier.height(28.dp))
        NabzPrimaryButton("Back to home", onDone)
    }
}
