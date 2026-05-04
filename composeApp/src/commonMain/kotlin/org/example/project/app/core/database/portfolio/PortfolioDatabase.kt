package org.example.project.app.core.database.portfolio

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import org.example.project.app.portfolio.data.local.PortfolioCoinEntity
import org.example.project.app.portfolio.data.local.PortfolioDao

@ConstructedBy(PortfolioDatabaseCreator::class)
@Database(entities = [PortfolioCoinEntity::class], version = 1)
abstract class PortfolioDatabase: RoomDatabase() {
    abstract fun portfolioDao(): PortfolioDao
}