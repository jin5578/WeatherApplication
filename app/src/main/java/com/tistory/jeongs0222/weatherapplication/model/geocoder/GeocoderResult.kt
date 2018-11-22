package com.tistory.jeongs0222.weatherapplication.model.geocoder

import com.google.gson.annotations.SerializedName


data class GeocoderResult(@SerializedName("region") val region: GeocoderRegion)
