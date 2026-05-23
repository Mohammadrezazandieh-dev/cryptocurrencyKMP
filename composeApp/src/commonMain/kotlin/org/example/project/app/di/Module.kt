package org.example.project.app.di

import androidx.room.RoomDatabase
import io.ktor.client.HttpClient
import org.example.project.app.coins.domain.api.CoinsRemoteDataSource
import org.example.project.app.coins.domain.GetCoinDetailsUseCase
import org.example.project.app.coins.domain.GetCoinsListUseCase
import org.example.project.app.coins.domain.GetCoinPriceHistoryUseCase
import org.example.project.app.coins.data.remote.impl.KtorCoinsRemoteDataSource
import org.example.project.app.coins.presentation.CoinsListViewModel
import org.example.project.app.core.database.portfolio.PortfolioDatabase
import org.example.project.app.core.database.portfolio.getPortfolioDatabase
import org.example.project.app.core.network.HttpClientFactory
import org.example.project.app.portfolio.data.PortfolioRepositoryImpl
import org.example.project.app.portfolio.domain.PortfolioRepository
import org.example.project.app.portfolio.presentation.PortfolioViewModel
import org.example.project.app.trade.domain.BuyCoinUseCase
import org.example.project.app.trade.domain.SellCoinUseCase
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.bind
import org.koin.dsl.module

fun initKoin(config: KoinAppDeclaration? = null) =
    startKoin {
        config?.invoke(this)
        modules(
            sharedModule,
            platformModule,
        )
    }


expect val platformModule: Module

val sharedModule = module {

    // core
    single<HttpClient> { HttpClientFactory.create(get()) }

    // portfolio
    single{
        getPortfolioDatabase(get<RoomDatabase.Builder<PortfolioDatabase>>())
    }

    singleOf(::PortfolioRepositoryImpl).bind<PortfolioRepository>()
    single { get<PortfolioDatabase>().portfolioDao() }
    single { get<PortfolioDatabase>().userBalanceDao() }
    viewModel { PortfolioViewModel(get()) }

    // coins list
    viewModel { CoinsListViewModel( get() , get()) }
    singleOf(::KtorCoinsRemoteDataSource).bind<CoinsRemoteDataSource>()
    singleOf(::GetCoinDetailsUseCase)
    singleOf(::GetCoinsListUseCase)
    singleOf(::GetCoinPriceHistoryUseCase)

    //trade
    singleOf(::BuyCoinUseCase)
    singleOf(::SellCoinUseCase)
}








