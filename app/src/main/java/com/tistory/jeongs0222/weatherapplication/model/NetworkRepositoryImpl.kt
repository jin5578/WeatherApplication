package com.tistory.jeongs0222.weatherapplication.model

import com.tistory.jeongs0222.weatherapplication.api.*
import com.tistory.jeongs0222.weatherapplication.model.finedust.FinedustResult
import com.tistory.jeongs0222.weatherapplication.model.geocoder.GeocoderAddress
import com.tistory.jeongs0222.weatherapplication.model.mediumForecast.MediumForecastResult
import com.tistory.jeongs0222.weatherapplication.model.mediumTemperature.MediumTemperatureResult
import com.tistory.jeongs0222.weatherapplication.model.shortForecast.ShortForecastItem
import io.reactivex.Single


class NetworkRepositoryImpl(private val geocoderApi: GeocoderApi, private val finedustApi: FinedustApi, private val goApi: GoApi) : Repository {

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

    override fun getShortForecast(
        serviceKey: String,
        baseDate: String,
        baseTime: String,
        nx: String,
        ny: String,
        numOfRows: String,
        pageNo: String,
        type: String
    ): Single<ShortForecastItem> {
        return goApi.shortForecast(serviceKey, baseDate, baseTime, nx, ny, numOfRows, pageNo, type)
            .map {
                  //it.response.body.items
                it.response.body.items
            }

    }

    override fun getMediumForecast(
        serviceKey: String,
        regId: String,
        tmFc: String,
        numOfRows: String,
        pageNo: String,
        type: String
    ): Single<MediumForecastResult> {
        return goApi.mediumForecast(serviceKey, regId, tmFc, numOfRows, pageNo, type)
            .map {
                it.response.body.items.item
            }
    }

    override fun getMediumTemperature(
        serviceKey: String,
        regId: String,
        tmFc: String,
        pageNo: String,
        numOfRows: String,
        type: String
    ): Single<MediumTemperatureResult> {
        return goApi.mediumTemperature(serviceKey, regId, tmFc, pageNo, numOfRows, type)
            .map {
                it.response.body.items.item
            }
    }
}