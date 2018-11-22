package com.tistory.jeongs0222.weatherapplication.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


class MainFinedustViewModel: DisposableViewModel() {


    private val _finedust_sort_textView = MutableLiveData<String>()
    val sort_textView: LiveData<String> get() = _finedust_sort_textView

    private val _finedust_imageView = MutableLiveData<String>()
    val imageView: LiveData<String> get() = _finedust_imageView

    private val _finedust_status_textView = MutableLiveData<String>()
    val status_textView: LiveData<String> get() = _finedust_status_textView

    private val _finedust_concentration_textView = MutableLiveData<String>()
    val concentration_textView: LiveData<String> get() = _finedust_concentration_textView
}