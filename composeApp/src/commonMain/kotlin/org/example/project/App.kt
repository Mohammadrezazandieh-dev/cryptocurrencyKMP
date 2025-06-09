package org.example.project

import androidx.compose.runtime.Composable
import org.example.project.app.coins.presentation.CoinsListScreen
import org.example.theme.CryptocurrencyTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    CryptocurrencyTheme {
        CoinsListScreen {  }
    }
}