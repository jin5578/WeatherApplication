package com.tistory.jeongs0222.weatherapplication.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tistory.jeongs0222.weatherapplication.utils.*


class MainMediumForecastViewModel: DisposableViewModel() {
    private val statusI = MutableLiveData<String>()
    val _statusI: LiveData<String> get() = statusI

    private val timeT = MutableLiveData<String>()
    val _timeT: LiveData<String> get() = timeT

    private val cloudyT = MutableLiveData<String>()
    val _cloudyT: LiveData<String> get() = cloudyT

    private val minTemperatureT = MutableLiveData<String>()
    val _minTemperatureT: LiveData<String> get() = minTemperatureT

    private val maxTemperatureT = MutableLiveData<String>()
    val _maxTemperatureT: LiveData<String> get() = maxTemperatureT

    /*fun bind(cItem: String, position: Int, tItem: ArrayList<String>) {
        val dateProvider = DateProviderImpl() as DateProvider
        val cloudyDivideProvider = CloudyDivideProviderImpl() as CloudyDivideProvider
        val temperatureDivideProvider = TemperatureDivideProviderImpl() as TemperatureDivideProvider

        Log.e("cItem", cItem)
        cloudyT.value = cItem
        timeT.value = dateProvider.getPositionDate(position)

        statusI.value = cloudyDivideProvider.cloudy_divider(cItem)

        if(!temperatureDivideProvider.positionDivier(position, tItem).isNullOrEmpty()) {
            val positionList = temperatureDivideProvider.positionDivier(position, tItem)

            positionList?.let {
                minTemperatureT.value = it[0]
                maxTemperatureT.value = it[1]
            }
        }

    }*/

    fun bind(cItem: String, position: Int) {
        val dateProvider = DateProviderImpl() as DateProvider
        val cloudyDivideProvider = CloudyDivideProviderImpl() as CloudyDivideProvider
        //val temperatureDivideProvider = TemperatureDivideProviderImpl() as TemperatureDivideProvider

        cloudyT.value = cItem
        timeT.value = dateProvider.getPositionDate(position)

        statusI.value = cloudyDivideProvider.cloudy_divider(cItem)

        minTemperatureT.value = "-5" + "°"
        maxTemperatureT.value = "6" + "°"

    }

}