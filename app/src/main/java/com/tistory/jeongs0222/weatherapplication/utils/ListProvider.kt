package com.tistory.jeongs0222.weatherapplication.utils

import com.tistory.jeongs0222.weatherapplication.model.mediumForecast.MediumForecastResult
import com.tistory.jeongs0222.weatherapplication.model.mediumTemperature.MediumTemperatureResult


interface ListProvider {

    fun mediumForecastAddList(it: MediumForecastResult): ArrayList<String>

    fun mediumTemperatureAddList(it: MediumTemperatureResult): ArrayList<String>

}

class ListProviderImpl : ListProvider {

    override fun mediumForecastAddList(it: MediumForecastResult): ArrayList<String> {
        var list = ArrayList<String>()

        list.add(0, it.wf3Am)
        list.add(1, it.wf3Pm)
        list.add(2, it.wf4Am)
        list.add(3, it.wf4Pm)
        list.add(4, it.wf5Am)
        list.add(5, it.wf5Pm)
        list.add(6, it.wf6Am)
        list.add(7, it.wf6Pm)
        list.add(8, it.wf7Am)
        list.add(9, it.wf7Pm)

        return list
    }

    override fun mediumTemperatureAddList(it: MediumTemperatureResult): ArrayList<String> {
        var list = ArrayList<String>()

        list.add(0, it.taMin3)
        list.add(1, it.taMax3)
        list.add(2, it.taMin4)
        list.add(3, it.taMax4)
        list.add(4, it.taMin5)
        list.add(5, it.taMax5)
        list.add(6, it.taMin6)
        list.add(7, it.taMax6)
        list.add(8, it.taMin7)
        list.add(9, it.taMax7)

        return list
    }

}