package com.tistory.jeongs0222.weatherapplication.model

import com.tistory.jeongs0222.weatherapplication.api.Api
import io.reactivex.Single


class NetworkRepositoryImpl(private val api: Api) : Repository {
    override fun getGeocoder(
        request: String,
        version: Float,
        coords: String,
        sourcecrs: String,
        output: String,
        orders: String
    ): Single<Address> {
        return api.geocoder(request, coords, sourcecrs, output, orders)
            .map {
                val region = it.results[0].region
                val address = "${region.area1.name} ${region.area2.name} ${region.area3.name}"

                Address(address)
            }
    }


}