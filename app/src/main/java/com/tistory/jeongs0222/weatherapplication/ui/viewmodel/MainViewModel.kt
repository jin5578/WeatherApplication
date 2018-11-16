package com.tistory.jeongs0222.weatherapplication.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tistory.jeongs0222.weatherapplication.utils.PermissionProvider
import com.tistory.jeongs0222.weatherapplication.utils.SingleLiveEvent


class MainViewModel(private val permissionProvider: PermissionProvider) : DisposableViewModel() {

    private val _present_location_textView = MutableLiveData<String>()
    val location_textView: LiveData<String>
        get() = _present_location_textView

    private val _present_emoticon_imageView = MutableLiveData<String>()
    val emoticon_imageView: LiveData<String>
        get() = _present_emoticon_imageView

    private val _present_status_textView = MutableLiveData<String>()
    val status_textView: LiveData<String>
        get() = _present_status_textView

    private val _present_explanation_textView = MutableLiveData<String>()
    val explation_textView: LiveData<String>
        get() = _present_explanation_textView

    private val _main_location_imageView = SingleLiveEvent<Any>()
    val location_imageView: LiveData<Any>
        get() = _main_location_imageView

    private val _showDialog = SingleLiveEvent<Any>()
    val showDialog: LiveData<Any>
        get() = _showDialog

    init {
        checkPermission()
    }

    private fun checkPermission() {
        if (permissionProvider.getLocationPermission()) {
            if (!permissionProvider.shouldShow()) {
                permissionProvider.requestPermission()
            }
        } else {
            //좌표위치 받아오는 부분
            Log.e("좌표 위치", "좌표 위치")
        }
    }

    fun bind() {
        _present_location_textView.value = "영등포구 당산동 6가"
        _present_status_textView.value = "매우 좋음"
        _present_explanation_textView.value = "화창합니다! 외출을 나가세요!"
    }

    fun locationClickEvent() {
        _main_location_imageView.call()
    }

    fun checkPermissionImage() {
        if (permissionProvider.getLocationPermission()) {
            _showDialog.call()
        }
    }

}