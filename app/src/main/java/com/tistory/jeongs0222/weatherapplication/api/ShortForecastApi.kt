package com.tistory.jeongs0222.weatherapplication.api

import com.tistory.jeongs0222.weatherapplication.model.shortForecast.ShortForecastResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query


interface ShortForecastApi {
    @GET("service/SecndSrtpdFrcstInfoService2/ForecastTimeData")
    fun shortForecast(@Query("ServiceKey", encoded = true) serviceKey: String,
                      @Query("base_date") baseDate: String,
                      @Query("base_time") baseTime: String,
                      @Query("nx") nx: String,
                      @Query("ny") ny: String,
                      @Query("numOfRows") numOfRows: String,
                      @Query("pageNo") pageNo: String,
                      @Query("_type") type: String): Single<ShortForecastResponse>
}