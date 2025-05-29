package org.example.project.app.coins.data.mapper

import org.example.project.app.coins.data.remote.dto.CoinItemDto
import org.example.project.app.coins.data.remote.dto.CoinPriceDto
import org.example.project.app.coins.domain.model.CoinModel
import org.example.project.app.coins.domain.model.PriceModel
import org.example.project.app.core.domain.coin.Coin

fun CoinItemDto.toCoinModel() = CoinModel(
    coin = Coin(
        id = uuid,
        name = name,
        symbol = symbol,
        iconUrl = iconUrl,
    ),
    price = price,
    change = change,
)

fun CoinPriceDto.toPriceModel() = PriceModel(
    price = price ?: 0.0,
    timestamp = timestamp,
)