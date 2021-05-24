package com.gemography.coding.challenge

import android.app.Application
import android.content.Context
import com.gemography.coding.challenge.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class GemographyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.INFO)
            androidContext(this@GemographyApplication)
            //Modules
            listOf(
                networkModule
            )
        }
    }

}