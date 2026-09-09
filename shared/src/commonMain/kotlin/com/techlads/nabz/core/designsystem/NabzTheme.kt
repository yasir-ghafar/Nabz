package com.techlads.nabz.core.designsystem

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val GoldSoft = Color(0xFFFFF4D6)

private val NabzColorScheme = lightColorScheme(
    primary = NabzColors.Crimson,
    onPrimary = NabzColors.Surface,
    primaryContainer = NabzColors.Rose,
    onPrimaryContainer = NabzColors.Wine,
    secondary = NabzColors.Gold,
    onSecondary = NabzColors.Ink,
    secondaryContainer = GoldSoft,
    onSecondaryContainer = NabzColors.Ink,
    tertiary = NabzColors.Success,
    onTertiary = NabzColors.Surface,
    tertiaryContainer = NabzColors.SuccessSoft,
    onTertiaryContainer = NabzColors.Success,
    background = NabzColors.Cream,
    onBackground = NabzColors.Ink,
    surface = NabzColors.Surface,
    onSurface = NabzColors.Ink,
    surfaceVariant = NabzColors.Rose,
    onSurfaceVariant = NabzColors.Muted,
    outline = NabzColors.Line,
    outlineVariant = NabzColors.RoseMuted,
    error = NabzColors.Emergency,
    onError = NabzColors.Surface,
)

@Composable
fun NabzTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = NabzColorScheme,
        typography = NabzTypography,
        shapes = NabzShapes,
        content = content,
    )
}
