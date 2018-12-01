package com.tistory.jeongs0222.weatherapplication.api

import com.tistory.jeongs0222.weatherapplication.model.shortForecast.ShortForecastResponse
import com.tistory.jeongs0222.weatherapplication.utils.shortForecastBaseUrl
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ShortForecastApi {

    /*@GET("{ServiceKey}/{base_date}/{base_time}/{nx}/{ny}/{numOfRows}/{pageNo}/{_type}")
    fun shortForecast(@Path("ServiceKey") serviceKey: String,
                      @Path("base_date") baseDate: String,
                      @Path("base_time") baseTime: String,
                      @Path("nx") nx: String,
                      @Path("ny") ny: String,
                      @Path("numOfRows") numOfRows: String,
                      @Path("pageNo") pageNo: String,
                      @Path("_type") type: String): Single<ShortForecastResponse>*/

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