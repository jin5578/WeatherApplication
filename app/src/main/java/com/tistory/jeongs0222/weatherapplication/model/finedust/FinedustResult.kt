package com.tistory.jeongs0222.weatherapplication.model.finedust


data class FinedustResult(val PM10: String,         //미세먼지
                          val PM25: String,         //초미세먼지
                          val NITROGEN: String,     //이산화질소
                          val OZONE: String,        //오존
                          val CARBON: String,       //일산화탄소
                          val SULFUROUS: String)    //아황산가스

