package com.vickikbt.gamex.di

import com.vickikbt.gamex.ui.screens.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

val appModule = module {
    viewModel { HomeViewModel(get()) }
}

val loadAppModule = lazy {
    //val modules=listOf(appModule)
    loadKoinModules(appModule)
}

/*
val appHomeModule by lazy {
    //val modules = listOf
    loadKoinModules(appModule)
}*/
