package com.techlads.nabz.core.designsystem.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.techlads.nabz.core.designsystem.NabzColors
import com.techlads.nabz.core.designsystem.icon.NabzIcons
import com.techlads.nabz.core.model.BloodRequest
import com.techlads.nabz.core.model.Donor

enum class MainTab { Home, Donors, Request, Banks, Profile }

@Composable
fun PulseLogo(
    modifier: Modifier = Modifier,
    dropColor: Color = NabzColors.Surface,
    pulseColor: Color = NabzColors.Crimson,
) {
    Canvas(modifier = modifier) {
        val w = size.minDimension
        val drop = Path().apply {
            moveTo(w / 2f, w * 0.06f)
            cubicTo(w * 0.78f, w * 0.32f, w * 0.94f, w * 0.50f, w * 0.94f, w * 0.66f)
            cubicTo(w * 0.94f, w * 0.86f, w * 0.74f, w * 0.96f, w / 2f, w * 0.96f)
            cubicTo(w * 0.26f, w * 0.96f, w * 0.06f, w * 0.86f, w * 0.06f, w * 0.66f)
            cubicTo(w * 0.06f, w * 0.50f, w * 0.22f, w * 0.32f, w / 2f, w * 0.06f)
            close()
        }
        drawPath(drop, dropColor)
        val y = w * 0.62f
        val pulse = Path().apply {
            moveTo(w * 0.22f, y)
            lineTo(w * 0.36f, y)
            lineTo(w * 0.42f, y - w * 0.12f)
            lineTo(w * 0.50f, y + w * 0.16f)
            lineTo(w * 0.58f, y - w * 0.08f)
            lineTo(w * 0.64f, y)
            lineTo(w * 0.78f, y)
        }
        drawPath(
            path = pulse,
            color = pulseColor,
            style = Stroke(width = w * 0.055f, cap = StrokeCap.Round),
        )
    }
}

@Composable
fun NabzPrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(
        onClick = onClick,
        modifier = modifier.fillMaxWidth().height(54.dp),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(containerColor = NabzColors.Crimson),
        contentPadding = PaddingValues(horizontal = 20.dp),
    ) {
        Text(text, style = MaterialTheme.typography.labelLarge, color = NabzColors.Surface)
    }
}

@Composable
fun NabzGhostButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier.fillMaxWidth().height(54.dp),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.outlinedButtonColors(contentColor = NabzColors.Crimson),
        border = androidx.compose.foundation.BorderStroke(1.dp, NabzColors.RoseMuted),
    ) {
        Text(text, style = MaterialTheme.typography.labelLarge)
    }
}

@Composable
fun NabzTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier.fillMaxWidth(),
        label = { Text(label) },
        singleLine = true,
        shape = RoundedCornerShape(14.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = NabzColors.Crimson,
            unfocusedBorderColor = NabzColors.Line,
            focusedContainerColor = NabzColors.Surface,
            unfocusedContainerColor = NabzColors.Surface,
            focusedLabelColor = NabzColors.Crimson,
        ),
    )
}

@Composable
fun BloodTypeChip(
    type: String,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val bg = if (selected) NabzColors.Crimson else NabzColors.Surface
    val fg = if (selected) NabzColors.Surface else NabzColors.Ink
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .background(bg)
            .border(1.dp, if (selected) NabzColors.Crimson else NabzColors.Line, RoundedCornerShape(20.dp))
            .clickable(onClick = onClick)
            .padding(horizontal = 14.dp, vertical = 8.dp),
        contentAlignment = Alignment.Center,
    ) {
        Text(type, color = fg, style = MaterialTheme.typography.labelLarge)
    }
}

@Composable
fun BloodTypeBadge(type: String, modifier: Modifier = Modifier, size: Dp = 44.dp) {
    Box(
        modifier = modifier
            .size(size)
            .clip(RoundedCornerShape(12.dp))
            .background(NabzColors.Rose),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = type,
            color = NabzColors.Crimson,
            fontWeight = FontWeight.Bold,
            fontSize = if (size >= 44.dp) 14.sp else 12.sp,
        )
    }
}

@Composable
fun InitialsAvatar(name: String, modifier: Modifier = Modifier, size: Dp = 48.dp) {
    val initials = name.split(" ").take(2).mapNotNull { it.firstOrNull()?.toString() }.joinToString("")
    Box(
        modifier = modifier
            .size(size)
            .clip(CircleShape)
            .background(NabzColors.Wine),
        contentAlignment = Alignment.Center,
    ) {
        Text(initials, color = NabzColors.Surface, fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
    }
}

@Composable
fun IconCircle(
    icon: ImageVector,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    tint: Color = NabzColors.Ink,
    background: Color = NabzColors.Surface.copy(alpha = 0.18f),
) {
    Box(
        modifier = modifier
            .size(40.dp)
            .clip(CircleShape)
            .background(background)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center,
    ) {
        Icon(icon, contentDescription = null, tint = tint, modifier = Modifier.size(18.dp))
    }
}

@Composable
fun DonorCard(donor: Donor, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(18.dp))
            .background(NabzColors.Surface)
            .clickable(onClick = onClick)
            .padding(14.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        InitialsAvatar(donor.name)
        Spacer(Modifier.width(12.dp))
        Column(Modifier.weight(1f)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(donor.name, style = MaterialTheme.typography.titleSmall, color = NabzColors.Ink)
                if (donor.verified) {
                    Spacer(Modifier.width(6.dp))
                    Icon(
                        NabzIcons.Shield,
                        contentDescription = null,
                        tint = NabzColors.Success,
                        modifier = Modifier.size(14.dp),
                    )
                }
            }
            Text(
                "${donor.area}, ${donor.city} · ${donor.distanceKm} km",
                style = MaterialTheme.typography.bodySmall,
                color = NabzColors.Muted,
            )
            Text(
                if (donor.available) "Available now" else "Last donated ${donor.lastDonated}",
                style = MaterialTheme.typography.labelMedium,
                color = if (donor.available) NabzColors.Success else NabzColors.Muted,
            )
        }
        BloodTypeBadge(donor.bloodType)
    }
}

@Composable
fun RequestCard(request: BloodRequest, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(18.dp))
            .background(NabzColors.Surface)
            .clickable(onClick = onClick)
            .padding(14.dp),
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            BloodTypeBadge(request.bloodType)
            Spacer(Modifier.width(12.dp))
            Column(Modifier.weight(1f)) {
                Text(request.patient, style = MaterialTheme.typography.titleSmall)
                Text(
                    "${request.hospital} · ${request.city}",
                    style = MaterialTheme.typography.bodySmall,
                    color = NabzColors.Muted,
                )
            }
            Text(request.postedAgo, style = MaterialTheme.typography.labelSmall, color = NabzColors.Muted)
        }
        Spacer(Modifier.height(10.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            InfoPill(request.urgency, if (request.urgency == "Critical") NabzColors.Rose else NabzColors.Cream)
            InfoPill("${request.units} units", NabzColors.Cream)
            InfoPill("${request.distanceKm} km", NabzColors.Cream)
        }
    }
}

@Composable
fun InfoPill(text: String, background: Color, modifier: Modifier = Modifier) {
    Text(
        text = text,
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .background(background)
            .padding(horizontal = 10.dp, vertical = 4.dp),
        style = MaterialTheme.typography.labelMedium,
        color = NabzColors.Ink,
    )
}

@Composable
fun SectionHeader(title: String, action: String? = null, onAction: (() -> Unit)? = null) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(title, style = MaterialTheme.typography.titleMedium, modifier = Modifier.weight(1f))
        if (action != null && onAction != null) {
            Text(
                action,
                color = NabzColors.Crimson,
                style = MaterialTheme.typography.labelLarge,
                modifier = Modifier.clickable(onClick = onAction),
            )
        }
    }
}

@Composable
fun NabzBottomBar(
    selected: MainTab,
    onSelect: (MainTab) -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(NabzColors.Surface)
            .border(width = 1.dp, color = NabzColors.Line, shape = RoundedCornerShape(0.dp))
            .navigationBarsPadding()
            .height(72.dp)
            .padding(horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
    ) {
        NavItem(NabzIcons.Home, "Home", selected == MainTab.Home) { onSelect(MainTab.Home) }
        NavItem(NabzIcons.Search, "Donors", selected == MainTab.Donors) { onSelect(MainTab.Donors) }
        Box(
            modifier = Modifier
                .size(56.dp)
                .clip(CircleShape)
                .background(NabzColors.Crimson)
                .clickable { onSelect(MainTab.Request) },
            contentAlignment = Alignment.Center,
        ) {
            Icon(NabzIcons.Drop, contentDescription = "Request", tint = NabzColors.Surface, modifier = Modifier.size(24.dp))
        }
        NavItem(NabzIcons.Hospital, "Banks", selected == MainTab.Banks) { onSelect(MainTab.Banks) }
        NavItem(NabzIcons.Person, "Profile", selected == MainTab.Profile) { onSelect(MainTab.Profile) }
    }
}

@Composable
private fun RowScope.NavItem(
    icon: ImageVector,
    label: String,
    selected: Boolean,
    onClick: () -> Unit,
) {
    val color = if (selected) NabzColors.Crimson else NabzColors.Muted
    Column(
        modifier = Modifier.weight(1f).clickable(onClick = onClick).padding(vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(icon, contentDescription = label, tint = color, modifier = Modifier.size(22.dp))
        Spacer(Modifier.height(4.dp))
        Text(label, color = color, style = MaterialTheme.typography.labelSmall)
    }
}

@Composable
fun ScreenTopBar(title: String, onBack: () -> Unit, trailing: @Composable (() -> Unit)? = null) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconCircle(
            icon = NabzIcons.ChevronLeft,
            onClick = onBack,
            tint = NabzColors.Ink,
            background = NabzColors.Surface,
        )
        Spacer(Modifier.width(12.dp))
        Text(title, style = MaterialTheme.typography.titleLarge, modifier = Modifier.weight(1f))
        trailing?.invoke()
    }
}
