package com.vickikbt.gamex

import android.app.Application
import com.vickikbt.domain.di.domainModule
import com.vickikbt.network.di.networkModule
import com.vickikbt.repository.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class GamexApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin()

        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }

    private fun initKoin() {
        val modules = listOf(domainModule, networkModule, repositoryModule)

        startKoin {
            androidLogger(level = Level.NONE)
            androidContext(this@GamexApplication)
            modules(modules)
        }
    }

}