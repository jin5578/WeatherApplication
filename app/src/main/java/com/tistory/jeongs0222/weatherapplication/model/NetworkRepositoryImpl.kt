package com.tistory.jeongs0222.weatherapplication.model

import com.tistory.jeongs0222.weatherapplication.api.Api
import com.tistory.jeongs0222.weatherapplication.api.GeocoderResponse2
import io.reactivex.Single


class NetworkRepositoryImpl(private val api: Api): Repository {
    override fun getGeocoder(request: String, version: Float, coords: String, sourcecrs: String, output: String, orders: String): Single<GeocoderResponse2> {
        return api.geocoder(request, version, coords, sourcecrs, output, orders)
            .map {
                it.results.region
            }
            /*.map {
                it.results
                //it.results
                //it.results.region.area0 + it.results.region.area1 + it.results.region.area2 + it.results.region.area3
            }*/
    }


}