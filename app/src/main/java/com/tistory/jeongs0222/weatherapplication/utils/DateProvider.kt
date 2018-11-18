package com.tistory.jeongs0222.weatherapplication.utils

import java.text.SimpleDateFormat
import java.util.*


interface DateProvider {

    fun getDate(): String

}

class DateProviderImpl: DateProvider {

    override fun getDate(): String {
        val mNow = System.currentTimeMillis()
        val mDate = Date(mNow)

        return SimpleDateFormat("yy.MM.dd hh:mm").format(mDate)
    }

}