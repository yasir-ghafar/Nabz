package com.techlads.nabz.feature.onboarding.ui

import androidx.compose.foundation.Canvas
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
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.unit.dp
import com.techlads.nabz.core.designsystem.NabzColors
import com.techlads.nabz.core.designsystem.component.NabzPrimaryButton

private data class OnboardingPage(
    val title: String,
    val body: String,
    val art: @Composable () -> Unit,
)

@Composable
fun OnboardingScreen(onFinished: () -> Unit) {
    val pages = remember {
        listOf(
            OnboardingPage(
                title = "Find donors nearby",
                body = "See verified matches by blood type, distance, and availability — in the moment it matters.",
                art = { NearbyArt() },
            ),
            OnboardingPage(
                title = "Request in minutes",
                body = "Post an emergency request and reach compatible donors around the hospital, not a city away.",
                art = { RequestArt() },
            ),
            OnboardingPage(
                title = "Feel the pulse of impact",
                body = "Track donations, eligibility, and lives reached. Nabz keeps the next drop ready.",
                art = { ImpactArt() },
            ),
        )
    }
    var index by remember { mutableStateOf(0) }
    val page = pages[index]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(NabzColors.Cream)
            .statusBarsPadding()
            .padding(horizontal = 24.dp, vertical = 16.dp),
    ) {
        Text(
            if (index < pages.lastIndex) "Skip" else " ",
            color = NabzColors.Muted,
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier
                .align(Alignment.End)
                .clickable(enabled = index < pages.lastIndex, onClick = onFinished)
                .padding(8.dp),
        )
        Spacer(Modifier.height(12.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .clip(MaterialTheme.shapes.extraLarge)
                .background(NabzColors.Rose),
            contentAlignment = Alignment.Center,
        ) {
            page.art()
        }
        Spacer(Modifier.height(28.dp))
        Text(page.title, style = MaterialTheme.typography.headlineMedium, color = NabzColors.Ink)
        Spacer(Modifier.height(10.dp))
        Text(page.body, style = MaterialTheme.typography.bodyLarge, color = NabzColors.Muted)
        Spacer(Modifier.height(28.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.weight(1f)) {
                pages.forEachIndexed { i, _ ->
                    Box(
                        Modifier
                            .height(8.dp)
                            .width(if (i == index) 22.dp else 8.dp)
                            .clip(CircleShape)
                            .background(if (i == index) NabzColors.Crimson else NabzColors.RoseMuted),
                    )
                }
            }
            Box(Modifier.width(160.dp)) {
                NabzPrimaryButton(
                    text = if (index == pages.lastIndex) "Get started" else "Next",
                    onClick = {
                        if (index == pages.lastIndex) onFinished() else index += 1
                    },
                )
            }
        }
        Spacer(Modifier.height(12.dp))
    }
}

@Composable
private fun NearbyArt() {
    Canvas(Modifier.size(220.dp)) {
        val c = Offset(size.width / 2f, size.height / 2f)
        drawCircle(NabzColors.RoseMuted, radius = size.minDimension * 0.42f, center = c)
        drawCircle(NabzColors.Crimson.copy(alpha = 0.18f), radius = size.minDimension * 0.28f, center = c)
        drawCircle(NabzColors.Crimson, radius = 18.dp.toPx(), center = c)
        listOf(
            Offset(c.x - 70.dp.toPx(), c.y - 24.dp.toPx()),
            Offset(c.x + 64.dp.toPx(), c.y + 8.dp.toPx()),
            Offset(c.x + 18.dp.toPx(), c.y - 68.dp.toPx()),
        ).forEach { p ->
            drawCircle(NabzColors.Surface, radius = 16.dp.toPx(), center = p)
            drawCircle(NabzColors.Crimson, radius = 7.dp.toPx(), center = p)
        }
    }
}

@Composable
private fun RequestArt() {
    Canvas(Modifier.size(220.dp)) {
        val path = Path().apply {
            val w = size.width
            val h = size.height
            moveTo(w * 0.22f, h * 0.30f)
            lineTo(w * 0.78f, h * 0.30f)
            quadraticTo(w * 0.88f, h * 0.30f, w * 0.88f, h * 0.40f)
            lineTo(w * 0.88f, h * 0.58f)
            quadraticTo(w * 0.88f, h * 0.68f, w * 0.78f, h * 0.68f)
            lineTo(w * 0.48f, h * 0.68f)
            lineTo(w * 0.38f, h * 0.80f)
            lineTo(w * 0.42f, h * 0.68f)
            lineTo(w * 0.22f, h * 0.68f)
            quadraticTo(w * 0.12f, h * 0.68f, w * 0.12f, h * 0.58f)
            lineTo(w * 0.12f, h * 0.40f)
            quadraticTo(w * 0.12f, h * 0.30f, w * 0.22f, h * 0.30f)
            close()
        }
        drawPath(path, NabzColors.Surface)
        drawCircle(NabzColors.Crimson, radius = 10.dp.toPx(), center = Offset(size.width * 0.35f, size.height * 0.48f))
        drawCircle(NabzColors.Gold, radius = 8.dp.toPx(), center = Offset(size.width * 0.50f, size.height * 0.48f))
        drawCircle(NabzColors.Success, radius = 8.dp.toPx(), center = Offset(size.width * 0.64f, size.height * 0.48f))
    }
}

@Composable
private fun ImpactArt() {
    Canvas(Modifier.size(220.dp)) {
        val c = Offset(size.width / 2f, size.height * 0.48f)
        val heart = Path().apply {
            moveTo(c.x, c.y + 48.dp.toPx())
            cubicTo(
                c.x - 70.dp.toPx(), c.y + 8.dp.toPx(),
                c.x - 64.dp.toPx(), c.y - 48.dp.toPx(),
                c.x, c.y - 18.dp.toPx(),
            )
            cubicTo(
                c.x + 64.dp.toPx(), c.y - 48.dp.toPx(),
                c.x + 70.dp.toPx(), c.y + 8.dp.toPx(),
                c.x, c.y + 48.dp.toPx(),
            )
            close()
        }
        drawPath(heart, NabzColors.Crimson)
    }
}
