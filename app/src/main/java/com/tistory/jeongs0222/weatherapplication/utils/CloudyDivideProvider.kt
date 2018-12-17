package com.tistory.jeongs0222.weatherapplication.utils


interface CloudyDivideProvider {

    fun cloudy_divider(value: String): String

}

class CloudyDivideProviderImpl: CloudyDivideProvider {

    override fun cloudy_divider(value: String): String {

        return when(value) {
            "맑음" -> "1"

            "흐림" -> "2"

            "흐리고 비" -> "2"              //임시로 흐림 그림만 넣어둠

            "흐리고 눈" -> "2"              //임시로 흐림 그림만 넣어둠

            "흐리고 비 흐리고 눈" -> "2"      //임시로 흐림 그림만 넣어둠

            "흐리고 비/눈" -> "2"           //임시로 흐림 그림만 넣어둠

            "흐리고 눈/비" -> "2"           //임시로 흐림 그림만 넣어둠

            "구름조금" -> "3"

            "구름많음" -> "4"               //임시로 구름많음 그림만 넣어둠

            "구름많고 비" -> "4"             //임시로 구름많음 그림만 넣어둠

            "구름많고 눈" -> "4"             //임시로 구름많음 그림만 넣어둠

            "구름많고 비/눈" -> "4"           //임시로 구름많음 그림만 넣어둠

            "구름많고 눈/비" -> "4"           //임시로 구름많음 그림만 넣어둠

            else -> null!!
        }
    }
}