package com.zhadko.composedemoapp

import android.app.Application
import com.zhadko.composedemoapp.di.dataModule
import com.zhadko.composedemoapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApp)
            modules(listOf(dataModule, viewModelModule))
        }
    }
}