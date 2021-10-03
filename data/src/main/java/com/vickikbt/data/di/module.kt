package com.vickikbt.data.di

import com.vickikbt.data.datasource.GamesRepositoryImpl
import com.vickikbt.data.networking.GamesService
import com.vickikbt.data.networking.GamesServiceImpl
import com.vickikbt.domain.repository.GamesRepository
import io.ktor.client.*
import org.koin.dsl.module

val dataModule = module {
    single<GamesService> { GamesServiceImpl(HttpClient()) }

    single<GamesRepository> { GamesRepositoryImpl(get()) }
}