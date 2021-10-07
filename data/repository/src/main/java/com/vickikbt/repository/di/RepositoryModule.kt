package com.vickikbt.repository.di

import com.vickikbt.domain.repository.GamesRepository
import com.vickikbt.repository.data_sources.GamesRepositoryImpl
import org.koin.dsl.module

val repositoryModule=module{

    single<GamesRepository>{ GamesRepositoryImpl(get()) }

}