package com.tistory.jeongs0222.weatherapplication.utils

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.provider.Settings
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

interface PermissionProvider {

    fun getLocationPermission(): Boolean

    fun shouldShow(): Boolean

    fun requestPermission()

    fun permissionAlert()

}

class PermissionProviderImpl(private val activity: Activity) : PermissionProvider {

    private val checkList = arrayOf(Manifest.permission.ACCESS_FINE_LOCATION)

    private val PERMISSION = 111;

    override fun getLocationPermission(): Boolean {
        return ContextCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
    }

    override fun shouldShow(): Boolean {
        return (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.ACCESS_FINE_LOCATION))
    }

    override fun requestPermission() {
        ActivityCompat.requestPermissions(activity, checkList, PERMISSION)
    }

    override fun permissionAlert() {
        Log.e("asd", "asd")
        AlertDialog.Builder(activity.applicationContext)
            .apply {
                setTitle("알림")
                setMessage("저장소 권한이 거부되었습니다. 사용을 원하시면 설정에서 해당 권한을 직접 허용하셔야 합니다.")
                setNeutralButton("설정", DialogInterface.OnClickListener { dialogInterface, which ->
                    val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                    intent.setData(Uri.parse("package:" + activity.packageName))

                    activity.startActivity(intent)
                })
                setCancelable(false)
            }
            .create()
            .show()
    }

}