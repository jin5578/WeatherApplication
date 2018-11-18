package com.tistory.jeongs0222.weatherapplication.model

import com.tistory.jeongs0222.weatherapplication.api.GeocoderResponse2
import io.reactivex.Single


interface Repository {

    fun getGeocoder(request: String,
                    version: Float,
                    coords: String,
                    sourcecrs: String,
                    output: String,
                    orders: String): Single<GeocoderResponse2>
}