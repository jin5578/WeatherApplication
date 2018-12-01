package com.tistory.jeongs0222.weatherapplication.utils


interface StringSplitProvider {

    fun stringSplit(hour: String): String
}

class StringSplitProviderImpl: StringSplitProvider {

    override fun stringSplit(hour: String): String = hour.substring(0, 2) + "시"

}