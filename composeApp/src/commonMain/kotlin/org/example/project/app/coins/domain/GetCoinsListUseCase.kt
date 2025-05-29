package org.example.project.app.coins.domain

import org.example.project.app.coins.data.mapper.toCoinModel
import org.example.project.app.coins.domain.api.CoinsRemoteDataSource
import org.example.project.app.coins.domain.model.CoinModel
import org.example.project.app.core.domain.DataError
import org.example.project.app.core.domain.Result
import org.example.project.app.core.domain.map

class GetCoinsListUseCase(
    private val client: CoinsRemoteDataSource,
) {

    suspend fun execute(): Result<List<CoinModel>, DataError.Remote> {
        return client.getListOfCoins().map { dto ->
            dto.data.coins.map { it.toCoinModel() }
        }
    }
}