package com.tistory.jeongs0222.weatherapplication.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query


interface Api {

    @GET("v2/gc")
    fun geocoder(@Query("request") request: String,
        @Query("version") version: Float,
        @Query("coords") coords: String,
        @Query("sourcecrs") sourcecrs: String,
        @Query("output") output: String,
        @Query("orders") orders: String): Single<GeocoderResponse>
}