package com.tistory.jeongs0222.weatherapplication.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*


interface DateProvider {

    fun getDate(): String

    fun getPositionDate(position: Int): String

}

class DateProviderImpl: DateProvider {

    @SuppressLint("SimpleDateFormat")
    override fun getDate(): String {
        val mNow = System.currentTimeMillis()
        val mDate = Date(mNow)

        return SimpleDateFormat("yy.MM.dd HH:mm").format(mDate)
    }

    override fun getPositionDate(position: Int): String {
        return when(position) {
            0 -> (position+3).toString()+"일 뒤 AM"

            1 -> (position+2).toString()+"일 뒤 PM"   //3일 뒤

            2 -> (position+2).toString()+"일 뒤 AM"

            3 -> (position+1).toString()+"일 뒤 PM"   //4일 뒤

            4 -> (position+1).toString()+"일 뒤 AM"

            5 -> position.toString()+"일 뒤 PM"       //5일 뒤

            6 -> position.toString()+"일 뒤 AM"

            7 -> (position-1).toString()+"일 뒤 PM"   //6일 뒤

            8 -> (position-1).toString()+"일 뒤 AM"

            9 -> (position-2).toString()+"일 뒤 PM"   //7일 뒤

            else -> null!!
        }
    }

}