package com.vickikbt.data.di

import com.vickikbt.data.datasource.GamesRepositoryImpl
import com.vickikbt.data.networking.GamesService
import com.vickikbt.data.networking.GamesServiceImpl
import com.vickikbt.domain.repository.GamesRepository
import org.koin.dsl.module

val dataModule = module {

    single<GamesService> { GamesServiceImpl(get()) }
    single<GamesRepository> { GamesRepositoryImpl(get()) }
}