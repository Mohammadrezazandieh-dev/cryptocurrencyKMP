package org.example.project.app.portfolio.domain

import org.example.project.app.core.domain.Result
import kotlinx.coroutines.flow.Flow
import org.example.project.app.core.domain.DataError
import org.example.project.app.core.domain.EmptyResult

interface PortfolioRepository {

    suspend fun initializeBalance()
    fun allPortfolioCoinsFlow(): Flow<Result<List<PortfolioCoinModel>, DataError.Remote>>
    suspend fun getPortfolioCoin(coinId: String): Result<PortfolioCoinModel?, DataError.Remote>
    suspend fun savePortfolioCoin(portfolioCoin: PortfolioCoinModel): EmptyResult<DataError.Local>
    suspend fun removeCoinFromPortfolio(coinId: String)

    fun calculateTotalPortfolioValue(): Flow<Result<Double, DataError. Remote>> // Total asset values + cash balance
    fun totalBalanceFlow(): Flow<Result<Double, DataError.Remote>> // Total asset values
    fun cashBalanceFlow(): Flow<Double>
    suspend fun updateCashBalance(newBalance: Double) // on buy and sell
}