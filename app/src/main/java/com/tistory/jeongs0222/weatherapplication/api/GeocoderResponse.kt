package com.tistory.jeongs0222.weatherapplication.api

import com.tistory.jeongs0222.weatherapplication.model.GeocoderArea


data class GeocoderResponse(val results: GeocoderResponse1)

data class GeocoderResponse1(val region: GeocoderResponse2)

data class GeocoderResponse2(val area0: GeocoderArea,
                             val area1: GeocoderArea,
                             val area2: GeocoderArea,
                             val area3: GeocoderArea)