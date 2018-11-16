package com.tistory.jeongs0222.weatherapplication.utils

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

interface PermissionProvider {

    fun getLocationPermission(): Boolean

    fun shouldShow(): Boolean

    fun requestPermission()
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

}