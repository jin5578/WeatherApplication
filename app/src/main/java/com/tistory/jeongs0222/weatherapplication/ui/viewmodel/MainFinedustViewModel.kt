package com.tistory.jeongs0222.weatherapplication.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tistory.jeongs0222.weatherapplication.model.finedust.FinedustResult


class MainFinedustViewModel: DisposableViewModel() {

    //미세먼지
    private val _pm10_imageView = MutableLiveData<String>()
    val pm10_imageView: LiveData<String> get() = _pm10_imageView

    private val _pm10_status_textView = MutableLiveData<String>()
    val pm10_status_textView: LiveData<String> get() = _pm10_status_textView

    private val _pm10_concentration_textView = MutableLiveData<String>()
    val pm10_concentration_textView: LiveData<String> get() = _pm10_concentration_textView

    //초미세먼지
    private val _pm25_imageView = MutableLiveData<String>()
    val pm25_imageView: LiveData<String> get() = pm25_imageView

    private val _pm25_status_textView = MutableLiveData<String>()
    val pm25_status_textView: LiveData<String> get() = _pm25_status_textView

    private val _pm25_concentration_textView = MutableLiveData<String>()
    val pm25_concentration_textView: LiveData<String> get() = _pm25_concentration_textView

    //이산화질소
    private val _nitrogen_imageView = MutableLiveData<String>()
    val nitrogen_imageView: LiveData<String> get() = _nitrogen_imageView

    private val _nitrogen_status_textView = MutableLiveData<String>()
    val nitrogen_status_textView: LiveData<String> get() = _nitrogen_status_textView

    private val _nitrogen_concentration_textView = MutableLiveData<String>()
    val nitrogen_concentration_textView: LiveData<String> get() = _nitrogen_concentration_textView

    //오존
    private val _ozone_imageView = MutableLiveData<String>()
    val ozone_imageView: LiveData<String> get() = _ozone_imageView

    private val _ozone_status_textView = MutableLiveData<String>()
    val ozone_status_textView: LiveData<String> get() = _ozone_status_textView

    private val _ozone_concentration_textView = MutableLiveData<String>()
    val ozone_concentration_textView: LiveData<String> get() = _ozone_concentration_textView

    //일산화탄소
    private val _carbon_imageView = MutableLiveData<String>()
    val carbon_imageView: LiveData<String> get() = _carbon_imageView

    private val _carbon_status_textView = MutableLiveData<String>()
    val carbon_status_textView: LiveData<String> get() = _carbon_status_textView

    private val _carbon_concentration_textView = MutableLiveData<String>()
    val carbon_concentration_textView: LiveData<String> get() = _carbon_concentration_textView

    //아황산가스
    private val _sulfurous_imageView = MutableLiveData<String>()
    val sulfurous_imageView: LiveData<String> get() = _sulfurous_imageView

    private val _sulfurous_status_textView = MutableLiveData<String>()
    val sulfurous_status_textView: LiveData<String> get() = _sulfurous_status_textView

    private val _sulfurous_concentration_textView = MutableLiveData<String>()
    val sulfurous_concentration_textView: LiveData<String> get() = _sulfurous_concentration_textView



    fun bind(bItem: FinedustResult) {
        Log.e("SULFUROUS", bItem.SULFUROUS)
        _pm10_concentration_textView.value = bItem.PM10 + " ㎍/㎥"
        _pm25_concentration_textView.value = bItem.PM25 + " ㎍/㎥"
        _nitrogen_concentration_textView.value = bItem.NITROGEN + "ppm"
        _ozone_concentration_textView.value = bItem.OZONE + " ppm"
        _carbon_concentration_textView.value = bItem.CARBON + " ppm"
        _sulfurous_concentration_textView.value = bItem.SULFUROUS + " ppm"
    }
}