package com.zhadko.composedemoapp.di

import com.zhadko.composedemoapp.repository.PlaceRepository
import com.zhadko.composedemoapp.repository.PlaceRepositoryImpl
import com.zhadko.composedemoapp.screens.placeListScreen.PlaceListViewModel
import com.zhadko.composedemoapp.utils.JSONReader
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dataModule = module {
    single { JSONReader() }
    single<PlaceRepository> { PlaceRepositoryImpl(get(), androidContext()) }
}

val viewModelModule = module {
    viewModel { PlaceListViewModel(get()) }
}