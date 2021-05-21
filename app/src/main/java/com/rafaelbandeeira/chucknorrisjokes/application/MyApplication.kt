package com.rafaelbandeeira.chucknorrisjokes.application

import android.app.Application
import com.rafaelbandeeira.chucknorrisjokes.diModule.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApplication)
            modules(listOf(viewModelModule))
        }
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
    }
}