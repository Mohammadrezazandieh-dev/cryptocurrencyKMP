package org.example.project.app.coins.domain

import org.example.project.app.coins.domain.model.CoinModel
import org.example.project.app.core.domain.DataError
import org.example.project.app.core.domain.map
import org.example.project.app.core.domain.Result
import org.example.project.app.coins.data.mapper.toCoinModel
import org.example.project.app.coins.domain.api.CoinsRemoteDataSource


class GetCoinDetailsUseCase(
    private val client: CoinsRemoteDataSource,
) {

    suspend fun execute(coinId: String): Result<CoinModel, DataError.Remote> {
        return client.getCoinById(coinId).map { dto ->
            dto.data.coin.toCoinModel()
        }
    }
}