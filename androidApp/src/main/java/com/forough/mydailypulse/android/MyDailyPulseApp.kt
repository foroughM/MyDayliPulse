package com.forough.mydailypulse.android

import android.app.Application
import com.forough.mydailypulse.android.di.databaseModule
import com.forough.mydailypulse.android.di.viewModelsModule
import com.forough.mydailypulse.di.sharedKoinModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyDailyPulseApp : Application() {


    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        val modules = sharedKoinModule + viewModelsModule + databaseModule
        startKoin {
            androidContext(this@MyDailyPulseApp)
            modules(modules)
        }
    }
}