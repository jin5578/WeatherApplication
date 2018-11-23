package com.tistory.jeongs0222.weatherapplication.model

import com.tistory.jeongs0222.weatherapplication.model.finedust.FinedustResult
import com.tistory.jeongs0222.weatherapplication.model.geocoder.GeocoderAddress
import com.tistory.jeongs0222.weatherapplication.model.geocoder.GeocoderResult
import io.reactivex.Single


interface Repository {

    fun getGeocoder(request: String,
                    version: Float,
                    coords: String,
                    sourcecrs: String,
                    output: String,
                    orders: String): Single<GeocoderAddress>

    fun getFinedust(key: String,
                    type: String,
                    service: String,
                    startIndex: Int,
                    endIndex: Int,
                    msradmcode: String): Single<FinedustResult>
}