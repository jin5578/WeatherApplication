package com.tistory.jeongs0222.weatherapplication.api

import com.tistory.jeongs0222.weatherapplication.model.mediumForecast.MediumForecastResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query


interface MediumForecastApi {
    @GET("service/MiddleFrcstInfoService/getMiddleLandWeather")
    fun mediumForecast(
        @Query("ServiceKey", encoded = true) serviceKey: String,
        @Query("regId") regId: String,
        @Query("tmFc") tmFc: String,
        @Query("numOfRows") numOfRows: String,
        @Query("pageNo") pageNo: String,
        @Query("_type") type: String): Single<MediumForecastResponse>

}