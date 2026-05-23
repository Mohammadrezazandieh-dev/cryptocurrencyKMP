package org.example.project.app.trade.presentation.mapper

import org.example.project.app.core.domain.coin.Coin
import org.example.project.app.trade.presentation.common.UiTradeCoinItem

fun UiTradeCoinItem.toCoin() = Coin(
    id = id,
    name = name,
    symbol = symbol,
    iconUrl = iconUrl
)