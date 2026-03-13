package com.example.pulse_ai.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import com.example.pulse_ai.ui.theme.backgroundDark
import com.example.pulse_ai.ui.theme.backgroundDarkHighContrast
import com.example.pulse_ai.ui.theme.backgroundDarkMediumContrast
import com.example.pulse_ai.ui.theme.backgroundLight
import com.example.pulse_ai.ui.theme.backgroundLightHighContrast
import com.example.pulse_ai.ui.theme.backgroundLightMediumContrast
import com.example.pulse_ai.ui.theme.errorContainerDark
import com.example.pulse_ai.ui.theme.errorContainerDarkHighContrast
import com.example.pulse_ai.ui.theme.errorContainerDarkMediumContrast
import com.example.pulse_ai.ui.theme.errorContainerLight
import com.example.pulse_ai.ui.theme.errorContainerLightHighContrast
import com.example.pulse_ai.ui.theme.errorContainerLightMediumContrast
import com.example.pulse_ai.ui.theme.errorDark
import com.example.pulse_ai.ui.theme.errorDarkHighContrast
import com.example.pulse_ai.ui.theme.errorDarkMediumContrast
import com.example.pulse_ai.ui.theme.errorLight
import com.example.pulse_ai.ui.theme.errorLightHighContrast
import com.example.pulse_ai.ui.theme.errorLightMediumContrast
import com.example.pulse_ai.ui.theme.inverseOnSurfaceDark
import com.example.pulse_ai.ui.theme.inverseOnSurfaceDarkHighContrast
import com.example.pulse_ai.ui.theme.inverseOnSurfaceDarkMediumContrast
import com.example.pulse_ai.ui.theme.inverseOnSurfaceLight
import com.example.pulse_ai.ui.theme.inverseOnSurfaceLightHighContrast
import com.example.pulse_ai.ui.theme.inverseOnSurfaceLightMediumContrast
import com.example.pulse_ai.ui.theme.inversePrimaryDark
import com.example.pulse_ai.ui.theme.inversePrimaryDarkHighContrast
import com.example.pulse_ai.ui.theme.inversePrimaryDarkMediumContrast
import com.example.pulse_ai.ui.theme.inversePrimaryLight
import com.example.pulse_ai.ui.theme.inversePrimaryLightHighContrast
import com.example.pulse_ai.ui.theme.inversePrimaryLightMediumContrast
import com.example.pulse_ai.ui.theme.inverseSurfaceDark
import com.example.pulse_ai.ui.theme.inverseSurfaceDarkHighContrast
import com.example.pulse_ai.ui.theme.inverseSurfaceDarkMediumContrast
import com.example.pulse_ai.ui.theme.inverseSurfaceLight
import com.example.pulse_ai.ui.theme.inverseSurfaceLightHighContrast
import com.example.pulse_ai.ui.theme.inverseSurfaceLightMediumContrast
import com.example.pulse_ai.ui.theme.onBackgroundDark
import com.example.pulse_ai.ui.theme.onBackgroundDarkHighContrast
import com.example.pulse_ai.ui.theme.onBackgroundDarkMediumContrast
import com.example.pulse_ai.ui.theme.onBackgroundLight
import com.example.pulse_ai.ui.theme.onBackgroundLightHighContrast
import com.example.pulse_ai.ui.theme.onBackgroundLightMediumContrast
import com.example.pulse_ai.ui.theme.onErrorContainerDark
import com.example.pulse_ai.ui.theme.onErrorContainerDarkHighContrast
import com.example.pulse_ai.ui.theme.onErrorContainerDarkMediumContrast
import com.example.pulse_ai.ui.theme.onErrorContainerLight
import com.example.pulse_ai.ui.theme.onErrorContainerLightHighContrast
import com.example.pulse_ai.ui.theme.onErrorContainerLightMediumContrast
import com.example.pulse_ai.ui.theme.onErrorDark
import com.example.pulse_ai.ui.theme.onErrorDarkHighContrast
import com.example.pulse_ai.ui.theme.onErrorDarkMediumContrast
import com.example.pulse_ai.ui.theme.onErrorLight
import com.example.pulse_ai.ui.theme.onErrorLightHighContrast
import com.example.pulse_ai.ui.theme.onErrorLightMediumContrast
import com.example.pulse_ai.ui.theme.onPrimaryContainerDark
import com.example.pulse_ai.ui.theme.onPrimaryContainerDarkHighContrast
import com.example.pulse_ai.ui.theme.onPrimaryContainerDarkMediumContrast
import com.example.pulse_ai.ui.theme.onPrimaryContainerLight
import com.example.pulse_ai.ui.theme.onPrimaryContainerLightHighContrast
import com.example.pulse_ai.ui.theme.onPrimaryContainerLightMediumContrast
import com.example.pulse_ai.ui.theme.onPrimaryDark
import com.example.pulse_ai.ui.theme.onPrimaryDarkHighContrast
import com.example.pulse_ai.ui.theme.onPrimaryDarkMediumContrast
import com.example.pulse_ai.ui.theme.onPrimaryLight
import com.example.pulse_ai.ui.theme.onPrimaryLightHighContrast
import com.example.pulse_ai.ui.theme.onPrimaryLightMediumContrast
import com.example.pulse_ai.ui.theme.onSecondaryContainerDark
import com.example.pulse_ai.ui.theme.onSecondaryContainerDarkHighContrast
import com.example.pulse_ai.ui.theme.onSecondaryContainerDarkMediumContrast
import com.example.pulse_ai.ui.theme.onSecondaryContainerLight
import com.example.pulse_ai.ui.theme.onSecondaryContainerLightHighContrast
import com.example.pulse_ai.ui.theme.onSecondaryContainerLightMediumContrast
import com.example.pulse_ai.ui.theme.onSecondaryDark
import com.example.pulse_ai.ui.theme.onSecondaryDarkHighContrast
import com.example.pulse_ai.ui.theme.onSecondaryDarkMediumContrast
import com.example.pulse_ai.ui.theme.onSecondaryLight
import com.example.pulse_ai.ui.theme.onSecondaryLightHighContrast
import com.example.pulse_ai.ui.theme.onSecondaryLightMediumContrast
import com.example.pulse_ai.ui.theme.onSurfaceDark
import com.example.pulse_ai.ui.theme.onSurfaceDarkHighContrast
import com.example.pulse_ai.ui.theme.onSurfaceDarkMediumContrast
import com.example.pulse_ai.ui.theme.onSurfaceLight
import com.example.pulse_ai.ui.theme.onSurfaceLightHighContrast
import com.example.pulse_ai.ui.theme.onSurfaceLightMediumContrast
import com.example.pulse_ai.ui.theme.onSurfaceVariantDark
import com.example.pulse_ai.ui.theme.onSurfaceVariantDarkHighContrast
import com.example.pulse_ai.ui.theme.onSurfaceVariantDarkMediumContrast
import com.example.pulse_ai.ui.theme.onSurfaceVariantLight
import com.example.pulse_ai.ui.theme.onSurfaceVariantLightHighContrast
import com.example.pulse_ai.ui.theme.onSurfaceVariantLightMediumContrast
import com.example.pulse_ai.ui.theme.onTertiaryContainerDark
import com.example.pulse_ai.ui.theme.onTertiaryContainerDarkHighContrast
import com.example.pulse_ai.ui.theme.onTertiaryContainerDarkMediumContrast
import com.example.pulse_ai.ui.theme.onTertiaryContainerLight
import com.example.pulse_ai.ui.theme.onTertiaryContainerLightHighContrast
import com.example.pulse_ai.ui.theme.onTertiaryContainerLightMediumContrast
import com.example.pulse_ai.ui.theme.onTertiaryDark
import com.example.pulse_ai.ui.theme.onTertiaryDarkHighContrast
import com.example.pulse_ai.ui.theme.onTertiaryDarkMediumContrast
import com.example.pulse_ai.ui.theme.onTertiaryLight
import com.example.pulse_ai.ui.theme.onTertiaryLightHighContrast
import com.example.pulse_ai.ui.theme.onTertiaryLightMediumContrast
import com.example.pulse_ai.ui.theme.outlineDark
import com.example.pulse_ai.ui.theme.outlineDarkHighContrast
import com.example.pulse_ai.ui.theme.outlineDarkMediumContrast
import com.example.pulse_ai.ui.theme.outlineLight
import com.example.pulse_ai.ui.theme.outlineLightHighContrast
import com.example.pulse_ai.ui.theme.outlineLightMediumContrast
import com.example.pulse_ai.ui.theme.outlineVariantDark
import com.example.pulse_ai.ui.theme.outlineVariantDarkHighContrast
import com.example.pulse_ai.ui.theme.outlineVariantDarkMediumContrast
import com.example.pulse_ai.ui.theme.outlineVariantLight
import com.example.pulse_ai.ui.theme.outlineVariantLightHighContrast
import com.example.pulse_ai.ui.theme.outlineVariantLightMediumContrast
import com.example.pulse_ai.ui.theme.primaryContainerDark
import com.example.pulse_ai.ui.theme.primaryContainerDarkHighContrast
import com.example.pulse_ai.ui.theme.primaryContainerDarkMediumContrast
import com.example.pulse_ai.ui.theme.primaryContainerLight
import com.example.pulse_ai.ui.theme.primaryContainerLightHighContrast
import com.example.pulse_ai.ui.theme.primaryContainerLightMediumContrast
import com.example.pulse_ai.ui.theme.primaryDark
import com.example.pulse_ai.ui.theme.primaryDarkHighContrast
import com.example.pulse_ai.ui.theme.primaryDarkMediumContrast
import com.example.pulse_ai.ui.theme.primaryLight
import com.example.pulse_ai.ui.theme.primaryLightHighContrast
import com.example.pulse_ai.ui.theme.primaryLightMediumContrast
import com.example.pulse_ai.ui.theme.scrimDark
import com.example.pulse_ai.ui.theme.scrimDarkHighContrast
import com.example.pulse_ai.ui.theme.scrimDarkMediumContrast
import com.example.pulse_ai.ui.theme.scrimLight
import com.example.pulse_ai.ui.theme.scrimLightHighContrast
import com.example.pulse_ai.ui.theme.scrimLightMediumContrast
import com.example.pulse_ai.ui.theme.secondaryContainerDark
import com.example.pulse_ai.ui.theme.secondaryContainerDarkHighContrast
import com.example.pulse_ai.ui.theme.secondaryContainerDarkMediumContrast
import com.example.pulse_ai.ui.theme.secondaryContainerLight
import com.example.pulse_ai.ui.theme.secondaryContainerLightHighContrast
import com.example.pulse_ai.ui.theme.secondaryContainerLightMediumContrast
import com.example.pulse_ai.ui.theme.secondaryDark
import com.example.pulse_ai.ui.theme.secondaryDarkHighContrast
import com.example.pulse_ai.ui.theme.secondaryDarkMediumContrast
import com.example.pulse_ai.ui.theme.secondaryLight
import com.example.pulse_ai.ui.theme.secondaryLightHighContrast
import com.example.pulse_ai.ui.theme.secondaryLightMediumContrast
import com.example.pulse_ai.ui.theme.surfaceBrightDark
import com.example.pulse_ai.ui.theme.surfaceBrightDarkHighContrast
import com.example.pulse_ai.ui.theme.surfaceBrightDarkMediumContrast
import com.example.pulse_ai.ui.theme.surfaceBrightLight
import com.example.pulse_ai.ui.theme.surfaceBrightLightHighContrast
import com.example.pulse_ai.ui.theme.surfaceBrightLightMediumContrast
import com.example.pulse_ai.ui.theme.surfaceContainerDark
import com.example.pulse_ai.ui.theme.surfaceContainerDarkHighContrast
import com.example.pulse_ai.ui.theme.surfaceContainerDarkMediumContrast
import com.example.pulse_ai.ui.theme.surfaceContainerHighDark
import com.example.pulse_ai.ui.theme.surfaceContainerHighDarkHighContrast
import com.example.pulse_ai.ui.theme.surfaceContainerHighDarkMediumContrast
import com.example.pulse_ai.ui.theme.surfaceContainerHighLight
import com.example.pulse_ai.ui.theme.surfaceContainerHighLightHighContrast
import com.example.pulse_ai.ui.theme.surfaceContainerHighLightMediumContrast
import com.example.pulse_ai.ui.theme.surfaceContainerHighestDark
import com.example.pulse_ai.ui.theme.surfaceContainerHighestDarkHighContrast
import com.example.pulse_ai.ui.theme.surfaceContainerHighestDarkMediumContrast
import com.example.pulse_ai.ui.theme.surfaceContainerHighestLight
import com.example.pulse_ai.ui.theme.surfaceContainerHighestLightHighContrast
import com.example.pulse_ai.ui.theme.surfaceContainerHighestLightMediumContrast
import com.example.pulse_ai.ui.theme.surfaceContainerLight
import com.example.pulse_ai.ui.theme.surfaceContainerLightHighContrast
import com.example.pulse_ai.ui.theme.surfaceContainerLightMediumContrast
import com.example.pulse_ai.ui.theme.surfaceContainerLowDark
import com.example.pulse_ai.ui.theme.surfaceContainerLowDarkHighContrast
import com.example.pulse_ai.ui.theme.surfaceContainerLowDarkMediumContrast
import com.example.pulse_ai.ui.theme.surfaceContainerLowLight
import com.example.pulse_ai.ui.theme.surfaceContainerLowLightHighContrast
import com.example.pulse_ai.ui.theme.surfaceContainerLowLightMediumContrast
import com.example.pulse_ai.ui.theme.surfaceContainerLowestDark
import com.example.pulse_ai.ui.theme.surfaceContainerLowestDarkHighContrast
import com.example.pulse_ai.ui.theme.surfaceContainerLowestDarkMediumContrast
import com.example.pulse_ai.ui.theme.surfaceContainerLowestLight
import com.example.pulse_ai.ui.theme.surfaceContainerLowestLightHighContrast
import com.example.pulse_ai.ui.theme.surfaceContainerLowestLightMediumContrast
import com.example.pulse_ai.ui.theme.surfaceDark
import com.example.pulse_ai.ui.theme.surfaceDarkHighContrast
import com.example.pulse_ai.ui.theme.surfaceDarkMediumContrast
import com.example.pulse_ai.ui.theme.surfaceDimDark
import com.example.pulse_ai.ui.theme.surfaceDimDarkHighContrast
import com.example.pulse_ai.ui.theme.surfaceDimDarkMediumContrast
import com.example.pulse_ai.ui.theme.surfaceDimLight
import com.example.pulse_ai.ui.theme.surfaceDimLightHighContrast
import com.example.pulse_ai.ui.theme.surfaceDimLightMediumContrast
import com.example.pulse_ai.ui.theme.surfaceLight
import com.example.pulse_ai.ui.theme.surfaceLightHighContrast
import com.example.pulse_ai.ui.theme.surfaceLightMediumContrast
import com.example.pulse_ai.ui.theme.surfaceVariantDark
import com.example.pulse_ai.ui.theme.surfaceVariantDarkHighContrast
import com.example.pulse_ai.ui.theme.surfaceVariantDarkMediumContrast
import com.example.pulse_ai.ui.theme.surfaceVariantLight
import com.example.pulse_ai.ui.theme.surfaceVariantLightHighContrast
import com.example.pulse_ai.ui.theme.surfaceVariantLightMediumContrast
import com.example.pulse_ai.ui.theme.tertiaryContainerDark
import com.example.pulse_ai.ui.theme.tertiaryContainerDarkHighContrast
import com.example.pulse_ai.ui.theme.tertiaryContainerDarkMediumContrast
import com.example.pulse_ai.ui.theme.tertiaryContainerLight
import com.example.pulse_ai.ui.theme.tertiaryContainerLightHighContrast
import com.example.pulse_ai.ui.theme.tertiaryContainerLightMediumContrast
import com.example.pulse_ai.ui.theme.tertiaryDark
import com.example.pulse_ai.ui.theme.tertiaryDarkHighContrast
import com.example.pulse_ai.ui.theme.tertiaryDarkMediumContrast
import com.example.pulse_ai.ui.theme.tertiaryLight
import com.example.pulse_ai.ui.theme.tertiaryLightHighContrast
import com.example.pulse_ai.ui.theme.tertiaryLightMediumContrast
import com.example.pulse_ai.ui.theme.AppTypography

private val lightScheme = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight,
    error = errorLight,
    onError = onErrorLight,
    errorContainer = errorContainerLight,
    onErrorContainer = onErrorContainerLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    surfaceVariant = surfaceVariantLight,
    onSurfaceVariant = onSurfaceVariantLight,
    outline = outlineLight,
    outlineVariant = outlineVariantLight,
    scrim = scrimLight,
    inverseSurface = inverseSurfaceLight,
    inverseOnSurface = inverseOnSurfaceLight,
    inversePrimary = inversePrimaryLight,
    surfaceDim = surfaceDimLight,
    surfaceBright = surfaceBrightLight,
    surfaceContainerLowest = surfaceContainerLowestLight,
    surfaceContainerLow = surfaceContainerLowLight,
    surfaceContainer = surfaceContainerLight,
    surfaceContainerHigh = surfaceContainerHighLight,
    surfaceContainerHighest = surfaceContainerHighestLight,
)

private val darkScheme = darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    tertiaryContainer = tertiaryContainerDark,
    onTertiaryContainer = onTertiaryContainerDark,
    error = errorDark,
    onError = onErrorDark,
    errorContainer = errorContainerDark,
    onErrorContainer = onErrorContainerDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
    surfaceVariant = surfaceVariantDark,
    onSurfaceVariant = onSurfaceVariantDark,
    outline = outlineDark,
    outlineVariant = outlineVariantDark,
    scrim = scrimDark,
    inverseSurface = inverseSurfaceDark,
    inverseOnSurface = inverseOnSurfaceDark,
    inversePrimary = inversePrimaryDark,
    surfaceDim = surfaceDimDark,
    surfaceBright = surfaceBrightDark,
    surfaceContainerLowest = surfaceContainerLowestDark,
    surfaceContainerLow = surfaceContainerLowDark,
    surfaceContainer = surfaceContainerDark,
    surfaceContainerHigh = surfaceContainerHighDark,
    surfaceContainerHighest = surfaceContainerHighestDark,
)

private val mediumContrastLightColorScheme = lightColorScheme(
    primary = primaryLightMediumContrast,
    onPrimary = onPrimaryLightMediumContrast,
    primaryContainer = primaryContainerLightMediumContrast,
    onPrimaryContainer = onPrimaryContainerLightMediumContrast,
    secondary = secondaryLightMediumContrast,
    onSecondary = onSecondaryLightMediumContrast,
    secondaryContainer = secondaryContainerLightMediumContrast,
    onSecondaryContainer = onSecondaryContainerLightMediumContrast,
    tertiary = tertiaryLightMediumContrast,
    onTertiary = onTertiaryLightMediumContrast,
    tertiaryContainer = tertiaryContainerLightMediumContrast,
    onTertiaryContainer = onTertiaryContainerLightMediumContrast,
    error = errorLightMediumContrast,
    onError = onErrorLightMediumContrast,
    errorContainer = errorContainerLightMediumContrast,
    onErrorContainer = onErrorContainerLightMediumContrast,
    background = backgroundLightMediumContrast,
    onBackground = onBackgroundLightMediumContrast,
    surface = surfaceLightMediumContrast,
    onSurface = onSurfaceLightMediumContrast,
    surfaceVariant = surfaceVariantLightMediumContrast,
    onSurfaceVariant = onSurfaceVariantLightMediumContrast,
    outline = outlineLightMediumContrast,
    outlineVariant = outlineVariantLightMediumContrast,
    scrim = scrimLightMediumContrast,
    inverseSurface = inverseSurfaceLightMediumContrast,
    inverseOnSurface = inverseOnSurfaceLightMediumContrast,
    inversePrimary = inversePrimaryLightMediumContrast,
    surfaceDim = surfaceDimLightMediumContrast,
    surfaceBright = surfaceBrightLightMediumContrast,
    surfaceContainerLowest = surfaceContainerLowestLightMediumContrast,
    surfaceContainerLow = surfaceContainerLowLightMediumContrast,
    surfaceContainer = surfaceContainerLightMediumContrast,
    surfaceContainerHigh = surfaceContainerHighLightMediumContrast,
    surfaceContainerHighest = surfaceContainerHighestLightMediumContrast,
)

private val highContrastLightColorScheme = lightColorScheme(
    primary = primaryLightHighContrast,
    onPrimary = onPrimaryLightHighContrast,
    primaryContainer = primaryContainerLightHighContrast,
    onPrimaryContainer = onPrimaryContainerLightHighContrast,
    secondary = secondaryLightHighContrast,
    onSecondary = onSecondaryLightHighContrast,
    secondaryContainer = secondaryContainerLightHighContrast,
    onSecondaryContainer = onSecondaryContainerLightHighContrast,
    tertiary = tertiaryLightHighContrast,
    onTertiary = onTertiaryLightHighContrast,
    tertiaryContainer = tertiaryContainerLightHighContrast,
    onTertiaryContainer = onTertiaryContainerLightHighContrast,
    error = errorLightHighContrast,
    onError = onErrorLightHighContrast,
    errorContainer = errorContainerLightHighContrast,
    onErrorContainer = onErrorContainerLightHighContrast,
    background = backgroundLightHighContrast,
    onBackground = onBackgroundLightHighContrast,
    surface = surfaceLightHighContrast,
    onSurface = onSurfaceLightHighContrast,
    surfaceVariant = surfaceVariantLightHighContrast,
    onSurfaceVariant = onSurfaceVariantLightHighContrast,
    outline = outlineLightHighContrast,
    outlineVariant = outlineVariantLightHighContrast,
    scrim = scrimLightHighContrast,
    inverseSurface = inverseSurfaceLightHighContrast,
    inverseOnSurface = inverseOnSurfaceLightHighContrast,
    inversePrimary = inversePrimaryLightHighContrast,
    surfaceDim = surfaceDimLightHighContrast,
    surfaceBright = surfaceBrightLightHighContrast,
    surfaceContainerLowest = surfaceContainerLowestLightHighContrast,
    surfaceContainerLow = surfaceContainerLowLightHighContrast,
    surfaceContainer = surfaceContainerLightHighContrast,
    surfaceContainerHigh = surfaceContainerHighLightHighContrast,
    surfaceContainerHighest = surfaceContainerHighestLightHighContrast,
)

private val mediumContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkMediumContrast,
    onPrimary = onPrimaryDarkMediumContrast,
    primaryContainer = primaryContainerDarkMediumContrast,
    onPrimaryContainer = onPrimaryContainerDarkMediumContrast,
    secondary = secondaryDarkMediumContrast,
    onSecondary = onSecondaryDarkMediumContrast,
    secondaryContainer = secondaryContainerDarkMediumContrast,
    onSecondaryContainer = onSecondaryContainerDarkMediumContrast,
    tertiary = tertiaryDarkMediumContrast,
    onTertiary = onTertiaryDarkMediumContrast,
    tertiaryContainer = tertiaryContainerDarkMediumContrast,
    onTertiaryContainer = onTertiaryContainerDarkMediumContrast,
    error = errorDarkMediumContrast,
    onError = onErrorDarkMediumContrast,
    errorContainer = errorContainerDarkMediumContrast,
    onErrorContainer = onErrorContainerDarkMediumContrast,
    background = backgroundDarkMediumContrast,
    onBackground = onBackgroundDarkMediumContrast,
    surface = surfaceDarkMediumContrast,
    onSurface = onSurfaceDarkMediumContrast,
    surfaceVariant = surfaceVariantDarkMediumContrast,
    onSurfaceVariant = onSurfaceVariantDarkMediumContrast,
    outline = outlineDarkMediumContrast,
    outlineVariant = outlineVariantDarkMediumContrast,
    scrim = scrimDarkMediumContrast,
    inverseSurface = inverseSurfaceDarkMediumContrast,
    inverseOnSurface = inverseOnSurfaceDarkMediumContrast,
    inversePrimary = inversePrimaryDarkMediumContrast,
    surfaceDim = surfaceDimDarkMediumContrast,
    surfaceBright = surfaceBrightDarkMediumContrast,
    surfaceContainerLowest = surfaceContainerLowestDarkMediumContrast,
    surfaceContainerLow = surfaceContainerLowDarkMediumContrast,
    surfaceContainer = surfaceContainerDarkMediumContrast,
    surfaceContainerHigh = surfaceContainerHighDarkMediumContrast,
    surfaceContainerHighest = surfaceContainerHighestDarkMediumContrast,
)

private val highContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkHighContrast,
    onPrimary = onPrimaryDarkHighContrast,
    primaryContainer = primaryContainerDarkHighContrast,
    onPrimaryContainer = onPrimaryContainerDarkHighContrast,
    secondary = secondaryDarkHighContrast,
    onSecondary = onSecondaryDarkHighContrast,
    secondaryContainer = secondaryContainerDarkHighContrast,
    onSecondaryContainer = onSecondaryContainerDarkHighContrast,
    tertiary = tertiaryDarkHighContrast,
    onTertiary = onTertiaryDarkHighContrast,
    tertiaryContainer = tertiaryContainerDarkHighContrast,
    onTertiaryContainer = onTertiaryContainerDarkHighContrast,
    error = errorDarkHighContrast,
    onError = onErrorDarkHighContrast,
    errorContainer = errorContainerDarkHighContrast,
    onErrorContainer = onErrorContainerDarkHighContrast,
    background = backgroundDarkHighContrast,
    onBackground = onBackgroundDarkHighContrast,
    surface = surfaceDarkHighContrast,
    onSurface = onSurfaceDarkHighContrast,
    surfaceVariant = surfaceVariantDarkHighContrast,
    onSurfaceVariant = onSurfaceVariantDarkHighContrast,
    outline = outlineDarkHighContrast,
    outlineVariant = outlineVariantDarkHighContrast,
    scrim = scrimDarkHighContrast,
    inverseSurface = inverseSurfaceDarkHighContrast,
    inverseOnSurface = inverseOnSurfaceDarkHighContrast,
    inversePrimary = inversePrimaryDarkHighContrast,
    surfaceDim = surfaceDimDarkHighContrast,
    surfaceBright = surfaceBrightDarkHighContrast,
    surfaceContainerLowest = surfaceContainerLowestDarkHighContrast,
    surfaceContainerLow = surfaceContainerLowDarkHighContrast,
    surfaceContainer = surfaceContainerDarkHighContrast,
    surfaceContainerHigh = surfaceContainerHighDarkHighContrast,
    surfaceContainerHighest = surfaceContainerHighestDarkHighContrast,
)

@Immutable
data class ColorFamily(
    val color: Color,
    val onColor: Color,
    val colorContainer: Color,
    val onColorContainer: Color
)

val unspecified_scheme = ColorFamily(
    Color.Unspecified, Color.Unspecified, Color.Unspecified, Color.Unspecified
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable() () -> Unit
) {
  val colorScheme = when {
      dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
          val context = LocalContext.current
          if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
      }
      
      darkTheme -> darkScheme
      else -> lightScheme
  }

  MaterialTheme(
    colorScheme = colorScheme,
    typography = AppTypography,
    content = content
  )
}

