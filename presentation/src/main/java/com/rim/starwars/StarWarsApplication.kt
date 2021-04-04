package com.rim.starwars

import android.app.Application
import com.facebook.stetho.Stetho
import com.rim.starwars.di.component.AppComponent
import com.rim.starwars.di.component.DaggerAppComponent

/**
 * Created by Rim Gazzah on 4/4/21.
 **/
class StarWarsApplication : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }
    override fun onCreate() {
        super.onCreate()
        initDI()
        initStetho()
    }
    private fun initDI() {
        appComponent = DaggerAppComponent.builder().build()
    }
    private fun initStetho() {
        if (BuildConfig.DEBUG) Stetho.initializeWithDefaults(this)
    }
}