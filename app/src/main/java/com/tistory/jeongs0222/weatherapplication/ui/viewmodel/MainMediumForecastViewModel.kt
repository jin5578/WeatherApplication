package com.tistory.jeongs0222.weatherapplication.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tistory.jeongs0222.weatherapplication.model.mediumForecast.MediumForecastResult
import com.tistory.jeongs0222.weatherapplication.utils.DateProvider
import com.tistory.jeongs0222.weatherapplication.utils.DateProviderImpl
import com.tistory.jeongs0222.weatherapplication.utils.GradeDivideProvider
import com.tistory.jeongs0222.weatherapplication.utils.GradeDivideProviderImpl


class MainMediumForecastViewModel: DisposableViewModel() {
    private val statusI = MutableLiveData<Int>()
    val _cloudyStatusI: LiveData<Int> get() = statusI

    private val timeT = MutableLiveData<String>()
    val _timeT: LiveData<String> get() = timeT

    private val temperatureT = MutableLiveData<String>()
    val _temperatureT: LiveData<String> get() = temperatureT

    fun bind(sItem: String, position: Int) {
        val dateProvider = DateProviderImpl() as DateProvider
        val gradeDivideProvider = GradeDivideProviderImpl() as GradeDivideProvider

        temperatureT.value = sItem
        timeT.value = dateProvider.getPositionDate(position)

        statusI.value = gradeDivideProvider.cloudy_divider(sItem)
    }

}