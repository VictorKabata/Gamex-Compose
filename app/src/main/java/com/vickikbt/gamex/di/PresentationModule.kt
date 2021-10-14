package com.vickikbt.gamex.di

import com.vickikbt.gamex.ui.screens.games_detail.GameDetailsViewModel
import com.vickikbt.gamex.ui.screens.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

val presentationModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { GameDetailsViewModel(get()) }
}

val loadPresentationModule by lazy {
    val modules = listOf(presentationModule)
    loadKoinModules(modules)
}