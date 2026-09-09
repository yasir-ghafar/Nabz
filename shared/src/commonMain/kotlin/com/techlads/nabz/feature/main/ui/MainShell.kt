package com.techlads.nabz.feature.main.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.techlads.nabz.core.designsystem.component.MainTab
import com.techlads.nabz.core.designsystem.component.NabzBottomBar
import com.techlads.nabz.core.model.Donor
import com.techlads.nabz.feature.banks.ui.BloodBanksScreen
import com.techlads.nabz.feature.donors.ui.FindDonorsScreen
import com.techlads.nabz.feature.home.ui.HomeScreen
import com.techlads.nabz.feature.profile.ui.ProfileScreen
import com.techlads.nabz.feature.request.ui.RequestBloodScreen

@Composable
fun MainShell(
    tab: MainTab,
    onTab: (MainTab) -> Unit,
    onOpenNotifications: () -> Unit,
    onOpenDonor: (Donor) -> Unit,
    onRequestSubmitted: () -> Unit,
) {
    Column(Modifier.fillMaxSize()) {
        Column(Modifier.weight(1f)) {
            when (tab) {
                MainTab.Home -> HomeScreen(
                    onOpenNotifications = onOpenNotifications,
                    onOpenDonors = { onTab(MainTab.Donors) },
                    onOpenRequest = { onTab(MainTab.Request) },
                    onOpenBanks = { onTab(MainTab.Banks) },
                    onOpenRequestDetail = { onTab(MainTab.Request) },
                )
                MainTab.Donors -> FindDonorsScreen(onOpenDonor = onOpenDonor)
                MainTab.Request -> RequestBloodScreen(
                    onBack = { onTab(MainTab.Home) },
                    onSubmitted = onRequestSubmitted,
                )
                MainTab.Banks -> BloodBanksScreen()
                MainTab.Profile -> ProfileScreen()
            }
        }
        NabzBottomBar(selected = tab, onSelect = onTab)
    }
}
