package com.techlads.nabz.app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.techlads.nabz.core.designsystem.NabzTheme
import com.techlads.nabz.core.designsystem.component.MainTab
import com.techlads.nabz.core.model.Donor
import com.techlads.nabz.feature.auth.ui.SignInScreen
import com.techlads.nabz.feature.auth.ui.WelcomeScreen
import com.techlads.nabz.feature.donors.ui.DonorProfileScreen
import com.techlads.nabz.feature.main.ui.MainShell
import com.techlads.nabz.feature.notifications.ui.NotificationsScreen
import com.techlads.nabz.feature.onboarding.ui.OnboardingScreen
import com.techlads.nabz.feature.request.ui.RequestSentScreen
import com.techlads.nabz.feature.splash.ui.SplashScreen

private sealed interface Route {
    data object Splash : Route
    data object Onboarding : Route
    data object Welcome : Route
    data object SignIn : Route
    data object Main : Route
    data class DonorProfile(val donor: Donor) : Route
    data object Notifications : Route
    data object RequestSent : Route
}

@Composable
@Preview
fun App() {
    NabzTheme {
        var route by remember { mutableStateOf<Route>(Route.Splash) }
        var tab by remember { mutableStateOf(MainTab.Home) }

        when (val current = route) {
            Route.Splash -> SplashScreen { route = Route.Onboarding }
            Route.Onboarding -> OnboardingScreen { route = Route.Welcome }
            Route.Welcome -> WelcomeScreen { route = Route.SignIn }
            Route.SignIn -> SignInScreen { route = Route.Main }
            Route.Main -> MainShell(
                tab = tab,
                onTab = { tab = it },
                onOpenNotifications = { route = Route.Notifications },
                onOpenDonor = { route = Route.DonorProfile(it) },
                onRequestSubmitted = { route = Route.RequestSent },
            )
            is Route.DonorProfile -> DonorProfileScreen(
                donor = current.donor,
                onBack = { route = Route.Main },
            )
            Route.Notifications -> NotificationsScreen { route = Route.Main }
            Route.RequestSent -> RequestSentScreen {
                tab = MainTab.Home
                route = Route.Main
            }
        }
    }
}
