package com.tistory.jeongs0222.weatherapplication.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tistory.jeongs0222.weatherapplication.model.shortForecast.ShortForecastResult
import com.tistory.jeongs0222.weatherapplication.utils.StringSplitProvider
import com.tistory.jeongs0222.weatherapplication.utils.StringSplitProviderImpl


class MainShortForecastViewModel: DisposableViewModel() {
    private val statusI = MutableLiveData<String>()
    val _statusI: LiveData<String> get() = statusI

    private val timeT = MutableLiveData<String>()
    val _timeT: LiveData<String> get() = timeT

    private val temperatureT = MutableLiveData<String>()
    val _temperatureT: LiveData<String> get() = temperatureT


    fun bind(tItem: ShortForecastResult, sItem: ShortForecastResult) {

        val stringSplitProvider = StringSplitProviderImpl() as StringSplitProvider

        timeT.value = stringSplitProvider.stringSplit(tItem.fcstTime)
        temperatureT.value = tItem.fcstValue + "°"

        statusI.value = sItem.fcstValue
    }
}