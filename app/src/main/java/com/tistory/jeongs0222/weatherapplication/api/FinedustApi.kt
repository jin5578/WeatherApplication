package com.tistory.jeongs0222.weatherapplication.api

import com.tistory.jeongs0222.weatherapplication.model.finedust.FinedustResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path


interface FinedustApi {

    @GET("{KEY}/{TYPE}/{SERVICE}/{START_INDEX}/{END_INDEX}/{MSRADMCODE}/")
    fun finedust(@Path("KEY") key: String,
                 @Path("TYPE") type: String,
                 @Path("SERVICE") service: String,
                 @Path("START_INDEX") startIndex: Int,
                 @Path("END_INDEX") endIndex: Int,
                 @Path("MSRADMCODE") msradmcode: String): Single<FinedustResponse>
}