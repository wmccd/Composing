package com.wmccd.composing

import android.app.Application
import android.content.Context

class MyApplication: Application() {

    //If you make context available this way don't forget the Manifest file
    //    <application
    //    android:name=".MyApplication"

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
    }

    companion object {
        lateinit  var appContext: Context

    }

}