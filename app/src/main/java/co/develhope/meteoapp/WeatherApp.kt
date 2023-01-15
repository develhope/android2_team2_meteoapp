package co.develhope.meteoapp

import android.app.Application
import android.content.Context

class WeatherApp: Application() {
    companion object {
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

}