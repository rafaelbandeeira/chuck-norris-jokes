package com.rafaelbandeeira.chucknorrisjokes.application

import android.app.Application

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
    }
}