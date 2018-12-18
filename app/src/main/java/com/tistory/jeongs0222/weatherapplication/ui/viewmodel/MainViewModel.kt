package com.tistory.jeongs0222.weatherapplication.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tistory.jeongs0222.weatherapplication.adapter.FinedustAdapter
import com.tistory.jeongs0222.weatherapplication.adapter.MediumForecastAdapter
import com.tistory.jeongs0222.weatherapplication.adapter.ShortForecastAdapter
import com.tistory.jeongs0222.weatherapplication.model.Repository
import com.tistory.jeongs0222.weatherapplication.model.finedust.FinedustResult
import com.tistory.jeongs0222.weatherapplication.model.geocoder.GeocoderAddress
import com.tistory.jeongs0222.weatherapplication.model.mediumForecast.MediumForecastResult
import com.tistory.jeongs0222.weatherapplication.model.mediumTemperature.MediumTemperatureResult
import com.tistory.jeongs0222.weatherapplication.model.shortForecast.ShortForecastResult
import com.tistory.jeongs0222.weatherapplication.utils.*
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


//class MainViewModel(private val permissionProvider: PermissionProvider, private val locationProvider: LocationProvider) : DisposableViewModel() {
class MainViewModel(private val repository: Repository) : DisposableViewModel() {

    private val startApp = MutableLiveData<Boolean>()
    val _startApp: LiveData<Boolean> get() = startApp

    private val readyApp = MutableLiveData<Boolean>()
    val _readyApp: LiveData<Boolean> get() = readyApp

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

    private lateinit var permissionProvider: PermissionProvider

    private lateinit var locationProvider: LocationProvider

    private val listProvider = ListProviderImpl() as ListProvider

    private var mediumForecastList = ArrayList<String>()


    init {
        //checkPermission()
        startApp.value = true

        getPresentDate()

        addDisposable(Single
            .concat(geoCoder(), getFinedust(), getShortForecast(), getMediumForecast())
            .concatWith(getMediumTemperature())
            .doOnComplete { Log.e("concat", "complete") }
            .doOnError { Log.e("concat", "error") }
            .subscribe())
    }

    fun checkPermission() {
        if (permissionProvider.getLocationPermission()) {
            Log.e("permission", "fail")
            if (!permissionProvider.shouldShow()) {
                permissionProvider.requestPermission()
            }
        } else {
            //좌표위치 받아오는 부분
            //compositeDisposable.add(locationProvider.getCurrentLocation())
            Log.e("gugugu", locationProvider.getCurrentLocation())
            Log.e("좌표 위치", "좌표 위치")
        }
    }

    fun bind(permissionProvider: PermissionProvider, locationProvider: LocationProvider) {
        this.permissionProvider = permissionProvider
        this.locationProvider = locationProvider

        preStatusT.value = "구름많음"
        preExplanationT.value = "우산을 꼭 챙기세요!"
    }

    fun locationClickEvent() {
        mainLocationI.call()
    }

    fun checkPermissionImage() {
        if (permissionProvider.getLocationPermission()) {
            _showDialog.call()
        }
    }

    private fun getPresentDate() {

        val dateProvider = DateProviderImpl() as DateProvider

        preTimeT.value = dateProvider.getDate()

    }

    private fun geoCoder(): Single<GeocoderAddress> {

        return repository.getGeocoder(
            "coordsToaddr",
            1.0.toFloat(),
            "126.814012,37.484822",
            "epsg:4326",
            "json",
            "roadaddr"
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSuccess {
                preLocationT.value = it.address
                Log.e("geocoder", "success")
            }
            .doOnError {
                it.printStackTrace()
                Log.e("geocoder", "error")
            }

    }

    //더미 값 넣어둠
    private fun getFinedust(): Single<FinedustResult> {

        return repository.getFinedust(
            "644c7563526a696e36336d50516942",
            "json",
            "ListAirQualityByDistrictService",
            1,
            5,
            "111142"
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSuccess {
                finedustAdapter.addItems(it)
                Log.e("fineDust", "success")
            }
            .doOnError {
                it.printStackTrace()
                Log.e("fineDust", "error")
            }

    }

    //더미 값 넣어둠
    private fun getShortForecast(): Single<List<ShortForecastResult>> {

        return repository.getShortForecast(
            "%2B%2B4DRXqUeVX3G7JHjDWjK6ezt9phL8Zi3t0o9OB5AWYVwq92UpGrNLX2NdHP4sgL2znxi6ntWh%2FoHxDjym6Mfg%3D%3D",
            "20181218",
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
            .doOnComplete {
                Log.e("shortForecast", "complete")
            }
            .doOnError {
                it.printStackTrace()
                Log.e("shortForecast", "error")
            }
            .toList()

    }

    private fun getMediumForecast(): Single<MediumForecastResult> {

        return repository.getMediumForecast(
            "%2B%2B4DRXqUeVX3G7JHjDWjK6ezt9phL8Zi3t0o9OB5AWYVwq92UpGrNLX2NdHP4sgL2znxi6ntWh%2FoHxDjym6Mfg%3D%3D",
            "11B00000",
            "201812180600",
            "1",
            "1",
            "json"
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSuccess {
                //mediumForecastAdapter.addItems(listProvider.mediumForecastAddList(it))
                mediumForecastList = listProvider.mediumForecastAddList(it)
                Log.e("mediumForecast", "success")
            }
            .doOnError {
                Log.e("mediumForecast", "error")
            }
    }

    private fun getMediumTemperature(): Single<MediumTemperatureResult> {
        return repository.getMediumTemperature(
            "%2B%2B4DRXqUeVX3G7JHjDWjK6ezt9phL8Zi3t0o9OB5AWYVwq92UpGrNLX2NdHP4sgL2znxi6ntWh%2FoHxDjym6Mfg%3D%3D",
            "11B10101",
            "201812180600",
            "1",
            "1",
            "json"
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSuccess {
                mediumForecastAdapter.addItems(mediumForecastList, listProvider.mediumTemperatureAddList(it))
                Log.e("mediumTemperature", "success")
            }
            .doOnError {
                it.printStackTrace()
                Log.e("mediumTemperature", "error")
            }

    }
}