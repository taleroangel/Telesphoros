package dev.taleroangel.telesphoros.presentation.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.ui.platform.LocalContext

/**
 * Application global theming
 */
@Composable
fun ApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    // Get the dynamic color scheme
    val context = LocalContext.current

    // Use material as base theming
    MaterialTheme(
        typography = ApplicationTypography,
        // Grab color scheme from system
        colorScheme = if (darkTheme) {
            dynamicDarkColorScheme(context)
        } else {
            dynamicLightColorScheme(context)
        },
    ) {
        // Invoke content
        content()
    }
}