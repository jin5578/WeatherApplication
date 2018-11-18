package com.tistory.jeongs0222.weatherapplication.model

import com.google.gson.annotations.SerializedName


data class GeocoderResponse(val results: List<GeocoderResult>)

data class GeocoderResult(@SerializedName("region") val region: GeocoderRegion)


data class GeocoderRegion(
    val area0: GeocoderArea,
    val area1: GeocoderArea,
    val area2: GeocoderArea,
    val area3: GeocoderArea
)

