package org.example.project.app.coins.domain.api

import org.example.project.app.core.domain.Result
import org.example.project.app.coins.data.remote.dto.CoinDetailsResponseDto
import org.example.project.app.coins.data.remote.dto.CoinPriceHistoryResponseDto
import org.example.project.app.coins.data.remote.dto.CoinsResponseDto
import org.example.project.app.core.domain.DataError

interface CoinsRemoteDataSource {

    suspend fun getListOfCoins(): Result<CoinsResponseDto, DataError.Remote>

    suspend fun getPriceHistory(coinId: String): Result<CoinPriceHistoryResponseDto, DataError.Remote>

    suspend fun getCoinById(coinId: String): Result<CoinDetailsResponseDto, DataError.Remote>
}