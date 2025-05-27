package org.example.project.app.coins.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class CoinDetailsResponseDto(
    val data: CoinsResponseDto,
)

@Serializable
data class CoinResponseDto(
    val coin: CoinItemDto,
)