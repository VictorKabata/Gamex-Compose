package com.vickikbt.domain.di

import com.vickikbt.domain.usecases.GetGameDetailsUseCase
import com.vickikbt.domain.usecases.GetGamesUseCase
import org.koin.dsl.module

val domainModule = module {
    single { GetGamesUseCase(get()) }
    single { GetGameDetailsUseCase(get()) }
}
