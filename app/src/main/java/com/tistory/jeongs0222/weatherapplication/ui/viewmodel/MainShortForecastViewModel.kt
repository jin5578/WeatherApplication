package com.tistory.jeongs0222.weatherapplication.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tistory.jeongs0222.weatherapplication.model.shortForecast.ShortForecastResult


class MainShortForecastViewModel: DisposableViewModel() {

    private val _status_imageView = MutableLiveData<String>()
    val status_imageView: LiveData<String> get() = _status_imageView

    private val _time_textView = MutableLiveData<String>()
    val time_textView: LiveData<String> get() = _time_textView

    private val _temperature_textView = MutableLiveData<String>()
    val temperature_textView: LiveData<String> get() = _temperature_textView

    fun bind(bItem: ShortForecastResult) {

        _time_textView.value = bItem.fcstTime
        _temperature_textView.value = bItem.fcstValue

    }
}