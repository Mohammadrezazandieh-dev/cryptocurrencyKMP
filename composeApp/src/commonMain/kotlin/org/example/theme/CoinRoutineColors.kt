package org.example.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class CryptocurrencyKMPColorsPalette(
    val profitGreen: Color = Color.Unspecified,
    val lossRed: Color = Color.Unspecified,
)

val ProfitGreenColor = Color(color = 0xFF32de84)
val LossRedColor = Color(color = 0xFFD2122E)

val DarkProfitGreenColor = Color(color = 0xFF32de84)
val DarkLossRedColor = Color(color = 0xFFD2122E)

val LightCryptocurrencyKMPColorsPalette = CryptocurrencyKMPColorsPalette(
    profitGreen = ProfitGreenColor,
    lossRed = LossRedColor,
)

val DarkCryptocurrencyKMPeColorsPalette = CryptocurrencyKMPColorsPalette(
    profitGreen = DarkProfitGreenColor,
    lossRed = DarkLossRedColor,
)

val LocalCryptocurrencyKMPColorsPalette = compositionLocalOf { CryptocurrencyKMPColorsPalette() }