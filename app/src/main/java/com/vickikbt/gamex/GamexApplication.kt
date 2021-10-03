package com.vickikbt.gamex

import android.app.Application
import com.vickikbt.data.di.dataModule
import com.vickikbt.domain.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class GamexApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidLogger(level = Level.NONE)
            androidContext(this@GamexApplication)
            modules(domainModule, dataModule)
        }
    }

}