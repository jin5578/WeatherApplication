package com.tistory.jeongs0222.weatherapplication.ui.view

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import com.tistory.jeongs0222.weatherapplication.R
import com.tistory.jeongs0222.weatherapplication.databinding.ActivitySplashBinding
import com.tistory.jeongs0222.weatherapplication.ui.viewmodel.SplashViewModel

class SplashActivity : BaseActivity<ActivitySplashBinding>() {

    override val layoutResourceId: Int = R.layout.activity_splash

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val splashViewModel = SplashViewModel()

        splashViewModel.openDelay.observe(this, Observer {
            if (it) startActivity(Intent(this, MainActivity::class.java))
        })

        viewDataBinding.splashViewModel = splashViewModel
        viewDataBinding.setLifecycleOwner(this)
    }
}
