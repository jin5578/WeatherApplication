package com.tistory.jeongs0222.weatherapplication.utils


interface EmoticonDivideProvider {

    fun emoticonDivider(status: String): Int

}

class EmoticonDividerProviderImpl: EmoticonDivideProvider {

    override fun emoticonDivider(status: String): Int {

        return when(status) {

            "좋음" -> 0

            "보통" -> 1

            "나쁨" -> 2

            "매우나쁨" -> 3

            else -> 0
        }
    }
}