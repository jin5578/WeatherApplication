package com.tistory.jeongs0222.weatherapplication.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.location.Geocoder
import android.location.Location
import android.util.Log
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.tasks.OnCompleteListener


interface LocationProvider {

    fun getCurrentLocation(): String


}

class LocationProviderImpl(private val activity: Activity): LocationProvider {
    private lateinit var mCurrentLocation: Location
    private lateinit var mFusedLocationClient: FusedLocationProviderClient

    private lateinit var mGeoCoder: Geocoder

    @SuppressLint("LongLogTag", "MissingPermission")
    override fun getCurrentLocation(): String {

        val mCompleteListener = OnCompleteListener<Location>() { task ->

            if(task.isSuccessful && task.result != null) {
                mCurrentLocation = task.result!!

                Log.e("위도, 경도", "위도 : " + mCurrentLocation.latitude + " 경도 : " + mCurrentLocation.longitude)

                //mGuString = getCurrentAddress()
                //Toast.makeText(activity.applicationContext, "위도 : " + mCurrentLocation.latitude + " 경도 : " + mCurrentLocation.longitude, Toast.LENGTH_LONG).show()
            } else {
                Log.d("LocationProviderImpl:exception", task.exception.toString())
            }
        }

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(activity)

        mFusedLocationClient!!.lastLocation.addOnCompleteListener(activity, mCompleteListener)

        return getCurrentAddress()

    }

    fun getCurrentAddress(): String {
        mGeoCoder = Geocoder(activity.applicationContext)

        val mResultList = mGeoCoder.getFromLocation(
            37.482257, 126.965238, 1)   //AVD로 작업하는 관계로 dummy 넣어

        Log.d("주소", "주소 : " + mResultList.get(0).getAddressLine(0))

        val array = mResultList.get(0).getAddressLine(0).split(", ")

        for(i in 0.. array.size - 1) {
            Log.e("asd", array[i])
        }

        return array[1]
    }
}