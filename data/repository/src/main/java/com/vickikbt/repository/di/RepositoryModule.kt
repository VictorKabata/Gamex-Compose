package com.vickikbt.repository.di

import com.vickikbt.domain.repository.GameDetailsRepository
import com.vickikbt.domain.repository.GamesRepository
import com.vickikbt.repository.data_source.GameDetailsRepositoryImpl
import com.vickikbt.repository.data_source.GamesRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<GamesRepository> { GamesRepositoryImpl(get()) }
    single<GameDetailsRepository> { GameDetailsRepositoryImpl(get()) }
}