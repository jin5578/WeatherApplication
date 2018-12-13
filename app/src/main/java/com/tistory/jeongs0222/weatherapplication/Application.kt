package com.tistory.jeongs0222.weatherapplication

import android.app.Application
import com.tistory.jeongs0222.weatherapplication.di.appModules
import org.koin.android.ext.android.startKoin


class Application: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin(this, appModules)
    }
}