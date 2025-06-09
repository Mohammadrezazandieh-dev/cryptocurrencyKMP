package org.example.project.app.preview

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.example.project.app.coins.presentation.component.PerformanceChart
import org.example.theme.CryptocurrencyTheme
import org.example.theme.LocalCryptocurrencyKMPColorsPalette


@Preview(showBackground = true)
@Composable
fun PerformanceChartLossPreview() {
    val sampleData = listOf(
        100.0, 95.0, 98.0, 92.0, 85.0, 88.0, 80.0, 75.0, 70.0, 65.0
    )

    CryptocurrencyTheme {
        PerformanceChart(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(16.dp),
            nodes = sampleData,
            profitColor = LocalCryptocurrencyKMPColorsPalette.current.profitGreen,
            lossColor = LocalCryptocurrencyKMPColorsPalette.current.lossRed
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PerformanceChartVolatilePreview() {
    val sampleData = listOf(
        100.0, 110.0, 90.0, 120.0, 80.0, 130.0, 70.0, 140.0, 60.0, 150.0
    )

    CryptocurrencyTheme {
        PerformanceChart(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(16.dp),
            nodes = sampleData,
            profitColor = LocalCryptocurrencyKMPColorsPalette.current.profitGreen,
            lossColor = LocalCryptocurrencyKMPColorsPalette.current.lossRed
        )
    }
}




