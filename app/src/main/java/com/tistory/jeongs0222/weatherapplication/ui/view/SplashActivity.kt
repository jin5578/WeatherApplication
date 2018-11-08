package com.tistory.jeongs0222.weatherapplication.ui.view

import android.os.Bundle
import com.tistory.jeongs0222.weatherapplication.R
import com.tistory.jeongs0222.weatherapplication.databinding.ActivitySplashBinding
import com.tistory.jeongs0222.weatherapplication.ui.viewmodel.SplashViewModel

class SplashActivity : BaseActivity<ActivitySplashBinding>() {

    override val layoutResourceId: Int = R.layout.activity_splash

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val splashViewModel = SplashViewModel()

        viewDataBinding.splashViewModel = splashViewModel
        viewDataBinding.setLifecycleOwner(this)
        //setContentView(R.layout.activity_splash)
    }
}
