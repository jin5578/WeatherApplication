package com.tistory.jeongs0222.weatherapplication.api

import com.tistory.jeongs0222.weatherapplication.model.finedust.FinedustResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query


interface FinedustApi {

    @GET("{KEY}/{TYPE}/{SERVICE}/{START_INDEX}/{END_INDEX}/{MSRADMCODE}")
    fun finedust(@Query("KEY") key: String,
                 @Query("TYPE") type: String,
                 @Query("SERVICE") service: String,
                 @Query("START_INDEX") startIndex: Int,
                 @Query("END_INDEX") endIndex: Int,
                 @Query("MSRADMCODE") msradmcode: String): Single<FinedustResponse>
}