package com.tistory.jeongs0222.weatherapplication.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tistory.jeongs0222.weatherapplication.model.finedust.FinedustResult
import com.tistory.jeongs0222.weatherapplication.utils.EmoticonDivideProvider
import com.tistory.jeongs0222.weatherapplication.utils.EmoticonDividerProviderImpl
import com.tistory.jeongs0222.weatherapplication.utils.GradeDivideProvider
import com.tistory.jeongs0222.weatherapplication.utils.GradeDivideProviderImpl


class MainFinedustViewModel: DisposableViewModel() {
    //미세먼지
    private val pm10I = MutableLiveData<Int>()
    val _pm10I: LiveData<Int> get() = pm10I

    private val pm10StatusT = MutableLiveData<String>()
    val _pm10StatusT: LiveData<String> get() = pm10StatusT

    private val pm10ConcentrationT = MutableLiveData<String>()
    val _pm10ConcentrationT: LiveData<String> get() = pm10ConcentrationT

    //초미세먼지
    private val pm25I = MutableLiveData<Int>()
    val _pm25I: LiveData<Int> get() = pm25I

    private val pm25StatusT = MutableLiveData<String>()
    val _pm25StatusT: LiveData<String> get() = pm25StatusT

    private val pm25ConcentrationT = MutableLiveData<String>()
    val _pm25ConcentrationT: LiveData<String> get() = pm25ConcentrationT

    //이산화질소
    private val nitrogenI = MutableLiveData<Int>()
    val _nitrogenI: LiveData<Int> get() = nitrogenI

    private val nitrogenStatusT = MutableLiveData<String>()
    val _nitrogenStatusT: LiveData<String> get() = nitrogenStatusT

    private val nitrogenConcentrationT = MutableLiveData<String>()
    val _nitrogenConcentrationT: LiveData<String> get() = nitrogenConcentrationT

    //오존
    private val ozoneI = MutableLiveData<Int>()
    val _ozoneI: LiveData<Int> get() = ozoneI

    private val ozoneStatusT = MutableLiveData<String>()
    val _ozoneStatusT: LiveData<String> get() = ozoneStatusT

    private val ozoneConcentrationT = MutableLiveData<String>()
    val _ozoneConcentrationT: LiveData<String> get() = ozoneConcentrationT

    //일산화탄소
    private val carbonI = MutableLiveData<Int>()
    val _carbonI: LiveData<Int> get() = carbonI

    private val carbonStatusT = MutableLiveData<String>()
    val _carbonStatusT: LiveData<String> get() = carbonStatusT

    private val carbonConcentrationT = MutableLiveData<String>()
    val _carbonConcentrationT: LiveData<String> get() = carbonConcentrationT

    //아황산가스
    private val sulfurousI = MutableLiveData<Int>()
    val _sulfurousI: LiveData<Int> get() = sulfurousI

    private val sulfurousStatusT = MutableLiveData<String>()
    val _sulfurousStatusT: LiveData<String> get() = sulfurousStatusT

    private val sulfurousConcentrationT = MutableLiveData<String>()
    val _sulfurousConcentrationT: LiveData<String> get() = sulfurousConcentrationT


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
        pm10StatusT.value = pm10_status
        pm25StatusT.value = pm25_status
        nitrogenStatusT.value = nitrogen_status
        ozoneStatusT.value = ozon_status
        carbonStatusT.value = carbon_status
        sulfurousStatusT.value = sulfurous_status

        //수치
        pm10ConcentrationT.value = bItem.PM10 + " ㎍/㎥"
        pm25ConcentrationT.value = bItem.PM25 + " ㎍/㎥"
        nitrogenConcentrationT.value = bItem.NITROGEN + "ppm"
        ozoneConcentrationT.value = bItem.OZONE + " ppm"
        carbonConcentrationT.value = bItem.CARBON + " ppm"
        sulfurousConcentrationT.value = bItem.SULFUROUS + " ppm"

        //이미지
        pm10I.value = emoticonDivideProvider.emoticonDivider(pm10_status)
        pm25I.value = emoticonDivideProvider.emoticonDivider(pm25_status)
        nitrogenI.value = emoticonDivideProvider.emoticonDivider(nitrogen_status)
        ozoneI.value = emoticonDivideProvider.emoticonDivider(ozon_status)
        carbonI.value = emoticonDivideProvider.emoticonDivider(carbon_status)
        sulfurousI.value = emoticonDivideProvider.emoticonDivider(sulfurous_status)
    }
}