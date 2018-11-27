package com.tistory.jeongs0222.weatherapplication.utils


interface GradeDivider {

    fun pm10_divider(value: Int): String

    fun pm25_divider(value: Int): String

    fun nitrogen_divider(value: Float): String

    fun ozon_divider(value: Float): String

    fun carbon_divider(value: Float): String

    fun sulfurous_divider(value: Float): String
}

class GradeDividerImpl : GradeDivider {

    override fun pm10_divider(value: Int): String {

        when (value) {
            in 0..30 -> {
                return "좋음"
            }

            in 31..80 -> {
                return "보통"
            }

            in 81..150 -> {
                return "나쁨"
            }

            else -> {
                return "매우나쁨"
            }
        }
    }

    override fun pm25_divider(value: Int): String {

        when (value) {
            in 0..15 -> {
                return "좋음"
            }

            in 16..35 -> {
                return "보통"
            }

            in 36..75 -> {
                return "나쁨"
            }

            else -> {
                return "매우나쁨"
            }
        }
    }

    override fun nitrogen_divider(value: Float): String {

        if ((value.compareTo(0.03)) > 0) {           //0.03보다 높다.

            if ((value.compareTo(0.06)) > 0) {       //0.05보다 높다.

                if((value.compareTo(0.2)) > 0) {

                    return "매우나쁨"

                } else {

                    return "나쁨"

                }

            } else {

                return "보통"

            }

        } else {

            return "좋음"

        }
    }

    override fun ozon_divider(value: Float): String {

        if((value.compareTo(0.03)) > 0) {

            if((value.compareTo(0.09)) > 0) {

                if((value.compareTo(0.15)) > 0) {

                    return "매우나쁨"

                } else {

                    return "나쁨"

                }
            } else {

                return "보통"

            }

        } else {

            return "좋음"

        }
    }

    override fun carbon_divider(value: Float): String {

        if((value.compareTo(2.0)) > 0) {

            if((value.compareTo(9.0)) > 0) {

                if((value.compareTo(0.15)) > 0) {

                    return "매우나쁨"

                } else {

                    return "나쁨"

                }

            } else {

                return "보통"

            }

        } else {

            return "좋음"

        }
    }

    override fun sulfurous_divider(value: Float): String {

        if((value.compareTo(0.02)) > 0) {

            if((value.compareTo(0.05)) > 0) {

                if((value.compareTo(0.15)) > 0) {

                    return "매우나쁨"

                } else {

                    return "나쁨"

                }

            } else {

                return "보통"

            }

        } else {

            return "좋음"

        }
    }
}