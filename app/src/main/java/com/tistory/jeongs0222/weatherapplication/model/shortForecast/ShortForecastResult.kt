package com.tistory.jeongs0222.weatherapplication.model.shortForecast


data class ShortForecastResult(val baseDate: String,
                               val baseTime: String,
                               val category: String,
                               val fcstDate: String,
                               val fcstTime: String,
                               val fcstValue: String,
                               val nx: String,
                               val ny: String)