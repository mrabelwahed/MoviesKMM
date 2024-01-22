package com.ramadanapps.movieskmm.android

import android.app.Application
import com.ramadanapps.movieskmm.android.di.appModule
import com.ramadanapps.movieskmm.di.getSharedModules
import org.koin.core.context.GlobalContext.startKoin

class MyApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
          modules(appModule + getSharedModules())
        }
    }
}