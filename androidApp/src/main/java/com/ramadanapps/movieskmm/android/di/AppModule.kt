package com.ramadanapps.movieskmm.android.di

import com.ramadanapps.movieskmm.android.home.HomeViewModel
import org.koin.dsl.module

val appModule = module {
     factory { HomeViewModel(get())}
}