package org.example.project.app.coins.domain

import org.example.project.app.core.domain.DataError
import org.example.project.app.core.domain.map
import org.example.project.app.core.domain.Result
import org.example.project.app.coins.data.mapper.toPriceModel
import org.example.project.app.coins.domain.api.CoinsRemoteDataSource
import org.example.project.app.coins.domain.model.PriceModel

class GetCoinPriceHistoryUseCase(
    private val client: CoinsRemoteDataSource,
) {

    suspend fun execute(coinId: String): Result<List<PriceModel>, DataError.Remote> {
        return client.getPriceHistory(coinId).map { dto ->
            dto.data.history.map { it.toPriceModel() }
        }
    }
}