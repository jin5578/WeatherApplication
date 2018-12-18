package com.tistory.jeongs0222.weatherapplication.ui.view

import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.widget.HorizontalScrollView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.tistory.jeongs0222.weatherapplication.R
import com.tistory.jeongs0222.weatherapplication.databinding.ActivityMainBinding
import com.tistory.jeongs0222.weatherapplication.ui.viewmodel.MainViewModel
import com.tistory.jeongs0222.weatherapplication.ui.viewmodel.MainViewModelFactory
import com.tistory.jeongs0222.weatherapplication.utils.LocationProvider
import com.tistory.jeongs0222.weatherapplication.utils.LocationProviderImpl
import com.tistory.jeongs0222.weatherapplication.utils.PermissionProvider
import com.tistory.jeongs0222.weatherapplication.utils.PermissionProviderImpl
import org.koin.android.ext.android.inject


class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val permissionProvider = PermissionProviderImpl(this) as PermissionProvider
    private val locationProvider = LocationProviderImpl(this) as LocationProvider

    override val layoutResourceId: Int = R.layout.activity_main

    private val PERMISSION = 111

    private val mainViewModelFactory: MainViewModelFactory by inject()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewDataBinding.mainFinedustLayout.finedustRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        viewDataBinding.mainShortforecastLayout.shortForecastRecyclerView.layoutManager = GridLayoutManager(this, 4)
        viewDataBinding.mainMediumfirecastLayout.mediumForecastRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)


        //val mainViewModel = MainViewModel(permissionProvider, locationProvider)

        val mainViewModel = ViewModelProviders.of(this, mainViewModelFactory).get(MainViewModel::class.java)
        //mainViewModel.bind()

        mainViewModel._startApp.observe(this, Observer {
            if(it == true) {
                mainViewModel.bind(permissionProvider, locationProvider)

                mainViewModel.checkPermission()
            }
        })

        mainViewModel._mainLocationI.observe(this, Observer {
           mainViewModel.checkPermissionImage()
        })

        mainViewModel.showDialog.observe(this, Observer {
            alertDialog()
        })

        viewDataBinding.mainViewModel = mainViewModel
        viewDataBinding.setLifecycleOwner(this@MainActivity)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == PERMISSION) {

            if (grantResults.isNotEmpty()) {

                for (i in 0..grantResults.size - 1) {

                    if (grantResults[i] == PackageManager.PERMISSION_DENIED) {
                        return
                    }

                }

            }

        }
    }

    private fun alertDialog() {
        AlertDialog.Builder(this)
            .apply {
                setTitle("알림")
                setMessage("저장소 권한이 거부되었습니다. 사용을 원하시면 설정에서 해당 권한을 직접 허용하셔야 합니다.")
                setNeutralButton("설정") { dialogInterface, which ->
                    val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                    intent.data = Uri.parse("package:$packageName")

                    startActivity(intent)
                }
                setCancelable(false)
            }
            .create()
            .show()
    }
}
