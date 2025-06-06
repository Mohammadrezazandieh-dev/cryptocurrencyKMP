package org.example.project.app.core.util

/**
 * working with decimal, precisions and string conversions differ between Android and IOS.
 * */
expect fun formatFiat(amount: Double, showDecimal: Boolean = true): String

expect fun formatCoinUnit(amount: Double, symbol: String): String

expect fun formatPercentage(amount: Double): String