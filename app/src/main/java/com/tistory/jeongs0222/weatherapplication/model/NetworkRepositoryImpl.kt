package com.tistory.jeongs0222.weatherapplication.model

import com.tistory.jeongs0222.weatherapplication.api.FinedustApi
import com.tistory.jeongs0222.weatherapplication.api.GeocoderApi
import com.tistory.jeongs0222.weatherapplication.model.finedust.FinedustResult
import com.tistory.jeongs0222.weatherapplication.model.geocoder.GeocoderAddress
import io.reactivex.Single


class NetworkRepositoryImpl(private val geocoderApi: GeocoderApi, private val finedustApi: FinedustApi) : Repository {

    override fun getGeocoder(
        request: String,
        version: Float,
        coords: String,
        sourcecrs: String,
        output: String,
        orders: String
    ): Single<GeocoderAddress> {
        return geocoderApi.geocoder(request, coords, sourcecrs, output, orders)
            .map {
                val region = it.results[0].region
                val address = "${region.area1.name} ${region.area2.name} ${region.area3.name}"

                GeocoderAddress(address)
            }
    }

    override fun getFinedust(
        key: String,
        type: String,
        service: String,
        startIndex: Int,
        endIndex: Int,
        msradmcode: String
    ): Single<FinedustResult> {
        return finedustApi.finedust(key, type, service, startIndex, endIndex, msradmcode)
            .map {

                it.ListAirQualityByDistrictService.row[0]

            }
    }


}