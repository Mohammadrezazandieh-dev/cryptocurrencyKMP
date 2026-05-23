package org.example.project.app.trade.presentation.common

import org.jetbrains.compose.resources.StringResource

data class TradeState(
    val isLoading: Boolean = false,
    val error: StringResource? = null,
    val availableAmountL: String = "",
    val amount: String = "",
    val coin: UiTradeCoinItem? = null
)