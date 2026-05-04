package org.example.project.app.di

import androidx.room.RoomDatabase
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.darwin.Darwin
import org.example.project.app.core.database.portfolio.PortfolioDatabase
import org.example.project.app.core.database.getPortfolioDatabaseBuilder
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.koin.dsl.bind

actual val platformModule = module {
    single<HttpClientEngine> { Darwin.create() }
    singleOf(::getPortfolioDatabaseBuilder).bind<RoomDatabase.Builder<PortfolioDatabase>>()
}