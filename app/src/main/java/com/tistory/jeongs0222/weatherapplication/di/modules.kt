package com.tistory.jeongs0222.weatherapplication.di

import com.tistory.jeongs0222.weatherapplication.BuildConfig
import com.tistory.jeongs0222.weatherapplication.R
import com.tistory.jeongs0222.weatherapplication.api.*
import com.tistory.jeongs0222.weatherapplication.utils.*
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.Module
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


val apiModules: Module = module {
    single {
        Retrofit.Builder()
            .client(OkHttpClient.Builder()
                .addInterceptor(get(headerInterceptor))
                .addInterceptor(get(loggingInterceptor))
                .build())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(geocoderBaseUrl)
            .build()
            .create(GeocoderApi::class.java)
    }

    single(headerInterceptor) {
        Interceptor { chain ->
            val builder = chain.request().newBuilder().apply {
                header("X-NCP-APIGW-API-KEY-ID", androidContext().resources.getString(R.string.naver_client_id))
                header("X-NCP-APIGW-API-KEY", androidContext().resources.getString(R.string.naver_api_key))
            }
            chain.proceed(builder.build())
        }
    }

    single(loggingInterceptor) {
        HttpLoggingInterceptor().apply {
            level = if(BuildConfig.DEBUG)
                HttpLoggingInterceptor.Level.BODY
            else
                HttpLoggingInterceptor.Level.NONE
        } as Interceptor
    }

    single {
        Retrofit.Builder()
            .client(OkHttpClient.Builder()
                .addInterceptor(get(loggingInterceptor))
                .build())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(finedustBaseUrl)
            .build()
            .create(FinedustApi::class.java)
    }

    single {
        Retrofit.Builder()
            .client(OkHttpClient.Builder()
                .addInterceptor(get(loggingInterceptor))
                .build())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(forecastBaseUrl)
            .build()
            .create(ShortForecastApi::class.java)
    }

    single {
        Retrofit.Builder()
            .client(OkHttpClient.Builder()
                .addInterceptor(get(loggingInterceptor))
                .build())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(forecastBaseUrl)
            .build()
            .create(MediumForecastApi::class.java)
    }

    single {
        Retrofit.Builder()
            .client(OkHttpClient.Builder()
                .addInterceptor(get(loggingInterceptor))
                .build())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(forecastBaseUrl)
            .build()
            .create(MediumTemperatureApi::class.java)
    }
}

val appModules = listOf(apiModules, geocoderModules)