package com.ramadanapps.movieskmm.util

import com.ramadanapps.movieskmm.util.Dispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

internal class AndroidDispatcher: Dispatcher {
    override val io: CoroutineDispatcher
        get() = Dispatchers.IO
}

internal actual fun provideDispatcher(): Dispatcher =  AndroidDispatcher()