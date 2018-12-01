package com.tistory.jeongs0222.weatherapplication.ui.viewmodel

import android.graphics.drawable.Drawable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bumptech.glide.Glide
import com.tistory.jeongs0222.weatherapplication.R
import com.tistory.jeongs0222.weatherapplication.model.finedust.FinedustResult
import com.tistory.jeongs0222.weatherapplication.utils.EmoticonDivideProvider
import com.tistory.jeongs0222.weatherapplication.utils.EmoticonDividerProviderImpl
import com.tistory.jeongs0222.weatherapplication.utils.GradeDivideProvider
import com.tistory.jeongs0222.weatherapplication.utils.GradeDivideProviderImpl


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

    val emoticon = arrayListOf(R.drawable.good, R.drawable.soso, R.drawable.bad, R.drawable.verybad)

    fun bind(bItem: FinedustResult) {

        val gradeDivideProvider = GradeDivideProviderImpl() as GradeDivideProvider
        val emoticonDivideProvider = EmoticonDividerProviderImpl() as EmoticonDivideProvider

        val pm10_status = gradeDivideProvider.pm10_divider(bItem.PM10.toInt())
        val pm25_status = gradeDivideProvider.pm25_divider(bItem.PM25.toInt())
        val nitrogen_status = gradeDivideProvider.nitrogen_divider(bItem.NITROGEN.toFloat())
        val ozon_status = gradeDivideProvider.ozon_divider(bItem.OZONE.toFloat())
        val carbon_status = gradeDivideProvider.carbon_divider(bItem.CARBON.toFloat())
        val sulfurous_status = gradeDivideProvider.sulfurous_divider(bItem.SULFUROUS.toFloat())

        //상태
        _pm10_status_textView.value = pm10_status
        _pm25_status_textView.value = pm25_status
        _nitrogen_status_textView.value = nitrogen_status
        _ozone_status_textView.value = ozon_status
        _carbon_status_textView.value = carbon_status
        _sulfurous_status_textView.value = sulfurous_status

        //수치
        _pm10_concentration_textView.value = bItem.PM10 + " ㎍/㎥"
        _pm25_concentration_textView.value = bItem.PM25 + " ㎍/㎥"
        _nitrogen_concentration_textView.value = bItem.NITROGEN + "ppm"
        _ozone_concentration_textView.value = bItem.OZONE + " ppm"
        _carbon_concentration_textView.value = bItem.CARBON + " ppm"
        _sulfurous_concentration_textView.value = bItem.SULFUROUS + " ppm"

        //이미지
        /*_pm10_imageView.value = emoticonDivideProvider.emoticonDivider(pm10_status)
        _pm25_imageView.value = emoticonDivideProvider.emoticonDivider(pm25_status)
        _nitrogen_imageView.value = emoticonDivideProvider.emoticonDivider(nitrogen_status)
        _ozone_imageView.value = emoticonDivideProvider.emoticonDivider(ozon_status)
        _carbon_imageView.value = emoticonDivideProvider.emoticonDivider(carbon_status)
        _sulfurous_imageView.value = emoticonDivideProvider.emoticonDivider(sulfurous_status)*/
    }
}