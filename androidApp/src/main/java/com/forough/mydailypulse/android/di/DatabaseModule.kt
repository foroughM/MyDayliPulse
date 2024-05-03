package com.forough.mydailypulse.android.di

import app.cash.sqldelight.db.SqlDriver
import com.forough.mydailypulse.db.DatabaseDriverFactory
import com.forough.mydailypulse.db.MyDailyPulseDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single<SqlDriver> { DatabaseDriverFactory(androidContext()).createDriver() }
    single { MyDailyPulseDatabase(get()) }
}