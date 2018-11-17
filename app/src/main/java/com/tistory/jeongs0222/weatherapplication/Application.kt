package com.tistory.jeongs0222.weatherapplication

import android.app.Application


class Application: Application() {

    override fun onCreate() {
        super.onCreate()

        //startKoin(this, appModules)
    }
}