package com.mj.family_meal_planner

import android.app.Application
import com.google.firebase.FirebaseApp
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class App: Application(){

    companion object{
        private lateinit var application: App
        fun getInstance(): App = application
    }

    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
        application = this
        Timber.plant(Timber.DebugTree())
    }
}