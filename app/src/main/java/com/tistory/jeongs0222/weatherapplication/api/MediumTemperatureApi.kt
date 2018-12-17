package com.tistory.jeongs0222.weatherapplication.api

import com.tistory.jeongs0222.weatherapplication.model.mediumTemperature.MediumTemperatureResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query


interface MediumTemperatureApi {
    @GET("service/MiddleFrcstInfoService/getMiddleTemperature")
    fun mediumTemperature(
        @Query("ServiceKey", encoded = true) serviceKey: String,
        @Query("regId") regId: String,
        @Query("tmFc") tmFc: String,
        @Query("pageNo") pageNo: String,
        @Query("numOfRows") numOfRows: String,
        @Query("_type") type: String): Single<MediumTemperatureResponse>

}