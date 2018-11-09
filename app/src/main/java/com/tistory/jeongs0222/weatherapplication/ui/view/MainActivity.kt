package com.tistory.jeongs0222.weatherapplication.ui.view

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import androidx.lifecycle.Observer
import com.tistory.jeongs0222.weatherapplication.R
import com.tistory.jeongs0222.weatherapplication.databinding.ActivityMainBinding
import com.tistory.jeongs0222.weatherapplication.ui.viewmodel.MainViewModel
import com.tistory.jeongs0222.weatherapplication.utils.PermissionProvider
import com.tistory.jeongs0222.weatherapplication.utils.PermissionProviderImpl


class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val permissionProvider = PermissionProviderImpl(this) as PermissionProvider

    override val layoutResourceId: Int = R.layout.activity_main

    private val PERMISSION = 111;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mainViewModel = MainViewModel(permissionProvider)

        mainViewModel.bind()

        mainViewModel.location_imageView.observe(this, Observer {
           mainViewModel.checkPermissionImage()
        })

        mainViewModel.showDialog.observe(this, Observer {
            alertDialog()
        })

        viewDataBinding.mainViewModel = mainViewModel
        viewDataBinding.setLifecycleOwner(this)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if(requestCode == PERMISSION) {

            if(grantResults.isNotEmpty()) {

                for(i in 0 .. grantResults.size - 1) {

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
                setNeutralButton("설정", DialogInterface.OnClickListener { dialogInterface, which ->
                    val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                    intent.setData(Uri.parse("package:" + packageName))

                    startActivity(intent)
                })
                setCancelable(false)
            }
            .create()
            .show()
    }
}
