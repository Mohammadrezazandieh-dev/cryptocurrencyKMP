package org.example.project.app.core.database

import androidx.room.Room
import androidx.room.RoomDatabase
import org.example.project.app.core.database.portfolio.PortfolioDatabase
import platform.Foundation.NSHomeDirectory

fun getPortfolioDatabaseBuilder(): RoomDatabase.Builder<PortfolioDatabase> {
    /**
     * NSHomeDirectory() --> pass to the application's home directory on IOS.
     * like:     val dbFile = context.getDatabasePath("portfolio.db") in android
     */

    val dbFile = NSHomeDirectory() + "/portfolio.db"
    return Room.databaseBuilder<PortfolioDatabase>(
        name = dbFile,
    )
}