package com.oseisolo.oseivpn.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Neon Purple Theme Colors
private val Purple80 = Color(0xFFA78BFA)
private val PurpleGrey80 = Color(0xFF7C3AED)
private val Pink80 = Color(0xFFF472B6)

private val Purple40 = Color(0xFF5B21B6)
private val PurpleGrey40 = Color(0xFF7C3AED)
private val Pink40 = Color(0xFFEC4899)

private val DarkBackground = Color(0xFF0F172A)
private val DarkSurface = Color(0xFF1E293B)
private val Cyan = Color(0xFF06B6D4)

private val darkColorScheme = darkColorScheme(
    primary = Purple80,
    onPrimary = Color.White,
    primaryContainer = Purple40,
    onPrimaryContainer = Purple80,
    secondary = Cyan,
    onSecondary = Color.Black,
    secondaryContainer = Color(0xFF0891B2),
    onSecondaryContainer = Color(0xFF22D3EE),
    tertiary = Pink80,
    onTertiary = Color.White,
    tertiaryContainer = Pink40,
    onTertiaryContainer = Pink80,
    error = Color(0xFFEF4444),
    onError = Color.White,
    errorContainer = Color(0xFFDC2626),
    onErrorContainer = Color(0xFFFECACA),
    background = DarkBackground,
    onBackground = Color(0xFFF8FAFC),
    surface = DarkSurface,
    onSurface = Color(0xFFF8FAFC),
    surfaceVariant = Color(0xFF475569),
    onSurfaceVariant = Color(0xFFCBD5E1),
    outline = Color(0xFF94A3B8),
    outlineVariant = Color(0xFF64748B),
    scrim = Color.Black,
)

/**
 * Osei VPN Theme - Futuristic Dark Theme with Neon Purple Accent
 * 
 * This composable applies the custom dark theme with glassmorphism
 * and cyberpunk-inspired colors throughout the application.
 */
@Composable
fun OseiVPNTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = darkColorScheme,
        typography = OseiVPNTypography,
        shapes = OseiVPNShapes,
        content = content
    )
}
