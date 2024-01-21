package com.ramadanapps.movieskmm.util

import com.ramadanapps.movieskmm.util.Dispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

internal class IOSDispatcher: Dispatcher {
    override val io: CoroutineDispatcher
        get() = Dispatchers.Default
}

internal actual fun provideDispatcher(): Dispatcher = IOSDispatcher()