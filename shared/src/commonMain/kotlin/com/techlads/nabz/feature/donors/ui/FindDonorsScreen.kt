package com.techlads.nabz.feature.donors.ui

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
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
import com.techlads.nabz.core.designsystem.component.BloodTypeChip
import com.techlads.nabz.core.designsystem.component.DonorCard
import com.techlads.nabz.core.designsystem.component.NabzTextField
import com.techlads.nabz.core.model.Donor
import com.techlads.nabz.core.model.SampleData

@Composable
fun FindDonorsScreen(onOpenDonor: (Donor) -> Unit) {
    var query by remember { mutableStateOf("") }
    var selectedType by remember { mutableStateOf("O+") }
    val donors = SampleData.donors.filter { donor ->
        val matchesType = selectedType == "All" || donor.bloodType == selectedType
        val matchesQuery = query.isBlank() ||
            donor.name.contains(query, ignoreCase = true) ||
            donor.city.contains(query, ignoreCase = true) ||
            donor.area.contains(query, ignoreCase = true)
        matchesType && matchesQuery
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(NabzColors.Cream)
            .statusBarsPadding(),
    ) {
        Column(Modifier.padding(horizontal = 20.dp, vertical = 12.dp)) {
            Text("Find donors", style = MaterialTheme.typography.headlineSmall)
            Text("Compatible, nearby, ready to help", style = MaterialTheme.typography.bodyMedium, color = NabzColors.Muted)
            Spacer(Modifier.height(14.dp))
            NabzTextField(query, { query = it }, "Search name or area")
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            (listOf("All") + SampleData.bloodTypes).forEach { type ->
                BloodTypeChip(type, selected = type == selectedType, onClick = { selectedType = type })
            }
        }
        Spacer(Modifier.height(12.dp))
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            items(donors, key = { it.id }) { donor ->
                DonorCard(donor, onClick = { onOpenDonor(donor) })
            }
            item { Spacer(Modifier.height(24.dp)) }
        }
    }
}
