package org.example.project.app.coins.data.remote.impl

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import org.example.project.app.coins.data.remote.dto.CoinDetailsResponseDto
import org.example.project.app.coins.data.remote.dto.CoinPriceHistoryResponseDto
import org.example.project.app.coins.data.remote.dto.CoinsResponseDto
import org.example.project.app.coins.domain.CoinsRemoteDataSource
import org.example.project.app.core.domain.DataError
import org.example.project.app.core.network.safeCall
import org.example.project.app.core.domain.Result

private const val BASE_URL = "https://api.coinranking.com/v2"

class KtorCoinsRemoteDataSource(
    private val httpClient: HttpClient
) : CoinsRemoteDataSource {

    override suspend fun getListOfCoins(): Result<CoinsResponseDto, DataError.Remote> {
        return safeCall {
            httpClient.get("$BASE_URL/coins")
        }
    }

    override suspend fun getPriceHistory(coinId: String): Result<CoinPriceHistoryResponseDto, DataError.Remote> {
        return safeCall {
            httpClient.get("$BASE_URL/coin/$coinId/history")
        }
    }

    override suspend fun getCoinById(coinId: String): Result<CoinDetailsResponseDto, DataError.Remote> {
        return safeCall {
            httpClient.get("$BASE_URL/coin/$coinId")
        }
    }
}