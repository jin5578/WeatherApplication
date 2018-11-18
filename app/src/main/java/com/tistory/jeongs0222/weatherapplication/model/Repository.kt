package com.tistory.jeongs0222.weatherapplication.model

import io.reactivex.Single


interface Repository {

    fun getGeocoder(request: String,
                    version: Float,
                    coords: String,
                    sourcecrs: String,
                    output: String,
                    orders: String): Single<Address>
}