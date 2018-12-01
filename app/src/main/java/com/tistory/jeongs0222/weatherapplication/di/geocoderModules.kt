package com.tistory.jeongs0222.weatherapplication.di

import com.tistory.jeongs0222.weatherapplication.api.FinedustApi
import com.tistory.jeongs0222.weatherapplication.model.NetworkRepositoryImpl
import com.tistory.jeongs0222.weatherapplication.model.Repository
import com.tistory.jeongs0222.weatherapplication.ui.viewmodel.MainViewModelFactory
import com.tistory.jeongs0222.weatherapplication.utils.PermissionProvider
import com.tistory.jeongs0222.weatherapplication.utils.PermissionProviderImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.Module
import org.koin.dsl.module.module


val geocoderModules: Module = module {

    factory {
        NetworkRepositoryImpl(get(), get(), get()) as Repository
    }

    factory {
        MainViewModelFactory(get())
    }

    /*factory {
        //PermissionProviderImpl(androidContext()) as PermissionProvider
    }*/
}