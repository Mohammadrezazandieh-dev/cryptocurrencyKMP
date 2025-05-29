package org.example.project.app.coins.domain.model

import org.example.project.app.core.domain.coin.Coin


data class CoinModel(
    val coin: Coin,
    val price: Double,
    val change: Double,
)