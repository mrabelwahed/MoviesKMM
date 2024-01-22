package com.ramadanapps.movieskmm.util

import com.ramadanapps.movieskmm.di.getSharedModules
import org.koin.core.context.startKoin
fun initKoin(){
    startKoin {
        modules(getSharedModules())
    }
}