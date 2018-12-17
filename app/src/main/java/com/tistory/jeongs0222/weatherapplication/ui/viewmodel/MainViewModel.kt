package com.tistory.jeongs0222.weatherapplication.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tistory.jeongs0222.weatherapplication.adapter.FinedustAdapter
import com.tistory.jeongs0222.weatherapplication.adapter.MediumForecastAdapter
import com.tistory.jeongs0222.weatherapplication.adapter.ShortForecastAdapter
import com.tistory.jeongs0222.weatherapplication.model.Repository
import com.tistory.jeongs0222.weatherapplication.model.mediumForecast.MediumForecastName
import com.tistory.jeongs0222.weatherapplication.utils.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


//class MainViewModel(private val permissionProvider: PermissionProvider, private val locationProvider: LocationProvider) : DisposableViewModel() {
class MainViewModel(private val repository: Repository) : DisposableViewModel() {

    private val preLocationT = MutableLiveData<String>()
    val _preLocationT: LiveData<String> get() = preLocationT

    private val preTimeT = MutableLiveData<String>()
    val _preTimeT: LiveData<String> get() = preTimeT

    private val preEmoticonI = MutableLiveData<String>()
    val _preEmoticonI: LiveData<String> get() = preEmoticonI

    private val preStatusT = MutableLiveData<String>()
    val _preStatusT: LiveData<String> get() = preStatusT

    private val preExplanationT = MutableLiveData<String>()
    val _preExplanationT: LiveData<String> get() = preExplanationT

    private val mainLocationI = SingleLiveEvent<Any>()
    val _mainLocationI: LiveData<Any> get() = mainLocationI

    private val _showDialog = SingleLiveEvent<Any>()
    val showDialog: LiveData<Any> get() = _showDialog

    //private var compositeDisposable = CompositeDisposable()

    val finedustAdapter = FinedustAdapter()

    val shortForecastAdapter = ShortForecastAdapter()

    val mediumForecastAdapter = MediumForecastAdapter()

    private val listProvider = ListProviderImpl() as ListProvider

    private var mediumForecastList = ArrayList<String>()


    init {
        //checkPermission()

        geoCoder()

        getPresentDate()

        getFinedust()

        getShortForecast()

        getMediumForecast()

        //getMediumTemperature()
    }

    /*private fun checkPermission() {
        if (permissionProvider.getLocationPermission()) {
            if (!permissionProvider.shouldShow()) {
                permissionProvider.requestPermission()
            }
        } else {
            //좌표위치 받아오는 부분
            //compositeDisposable.add(locationProvider.getCurrentLocation())
            Log.e("gugugu", locationProvider.getCurrentLocation())
            Log.e("좌표 위치", "좌표 위치")
        }
    }*/

    fun bind() {
        preLocationT.value = "영등포구 당산동 6가"
        preStatusT.value = "매우 좋음"
        preExplanationT.value = "화창합니다! 외출을 나가세요!"
    }

    fun locationClickEvent() {
        mainLocationI.call()
    }

    /*fun checkPermissionImage() {
        if (permissionProvider.getLocationPermission()) {
            _showDialog.call()
        }
    }*/

    private fun geoCoder() {
        addDisposable(
            repository.getGeocoder(
                "coordsToaddr",
                1.0.toFloat(),
                "126.814012,37.484822",
                "epsg:4326",
                "json",
                "roadaddr"
            )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    preLocationT.value = it.address
                }, {
                    it.printStackTrace()
                })
        )
    }

    private fun getPresentDate() {
        val dateProvider = DateProviderImpl() as DateProvider

        preTimeT.value = dateProvider.getDate()
    }

    //더미 값 넣어둠
    private fun getFinedust() {
        Log.e("start", "start")
        addDisposable(
            repository.getFinedust(
                "644c7563526a696e36336d50516942",
                "json",
                "ListAirQualityByDistrictService",
                1,
                5,
                "111142"
            )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Log.e("PM10", it.PM10)
                    finedustAdapter.addItems(it)
                }, {
                    Log.e("fail", "fail")
                    it.printStackTrace()
                })
        )
    }

    //더미 값 넣어둠
    private fun getShortForecast() {
        addDisposable(repository.getShortForecast(
            "%2B%2B4DRXqUeVX3G7JHjDWjK6ezt9phL8Zi3t0o9OB5AWYVwq92UpGrNLX2NdHP4sgL2znxi6ntWh%2FoHxDjym6Mfg%3D%3D",
            "20181217",
            "1400",
            "55",
            "127",
            "1000",
            "1",
            "json"
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .toObservable()
            .map { it.item }
            .flatMapIterable { it }
            .filter { it.category == "T1H" || it.category == "SKY" }
            .doOnNext { shortForecastAdapter.addItems(it) }
            .doOnError { it.printStackTrace() }
            .subscribe())
    }

    private fun getMediumForecast() {
        addDisposable(repository.getMediumForecast(
            "%2B%2B4DRXqUeVX3G7JHjDWjK6ezt9phL8Zi3t0o9OB5AWYVwq92UpGrNLX2NdHP4sgL2znxi6ntWh%2FoHxDjym6Mfg%3D%3D",
            "11B00000",
            "201812170600",
            "1",
            "1",
            "json"
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mediumForecastAdapter.addItems(listProvider.mediumForecastAddList(it))
                //mediumForecastList = listProvider.mediumForecastAddList(it)
            }, {
                it.printStackTrace()
            })
        )
    }

    /*private fun getMediumTemperature() {
        addDisposable(repository.getMediumTemperature(
            "%2B%2B4DRXqUeVX3G7JHjDWjK6ezt9phL8Zi3t0o9OB5AWYVwq92UpGrNLX2NdHP4sgL2znxi6ntWh%2FoHxDjym6Mfg%3D%3D",
            "11B10101",
            "201812170600",
            "1",
            "1",
            "json"
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mediumForecastAdapter.addItems(mediumForecastList, listProvider.mediumTemperatureAddList(it))
            }, {
                it.printStackTrace()
            }))
    }*/
}