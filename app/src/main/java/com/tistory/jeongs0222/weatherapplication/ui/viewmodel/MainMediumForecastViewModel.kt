package com.tistory.jeongs0222.weatherapplication.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tistory.jeongs0222.weatherapplication.utils.*


class MainMediumForecastViewModel: DisposableViewModel() {
    private val statusI = MutableLiveData<String>()
    val _statusI: LiveData<String> get() = statusI

    private val timeT = MutableLiveData<String>()
    val _timeT: LiveData<String> get() = timeT

    private val temperatureT = MutableLiveData<String>()
    val _temperatureT: LiveData<String> get() = temperatureT

    fun bind(sItem: String, position: Int) {
        val dateProvider = DateProviderImpl() as DateProvider
        val cloudyDivideProvider = CloudyDivideProviderImpl() as CloudyDivideProvider

        temperatureT.value = sItem
        timeT.value = dateProvider.getPositionDate(position)

        statusI.value = cloudyDivideProvider.cloudy_divider(sItem)
    }

}