package com.natiqhaciyef.kmm_movie.android.di

import android.app.Application
import com.natiqhaciyef.kmm_movie.di.getSharedModules
import org.koin.core.context.startKoin

class Movie : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule + getSharedModules())
        }
    }
}