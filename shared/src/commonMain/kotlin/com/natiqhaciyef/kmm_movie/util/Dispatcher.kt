package com.natiqhaciyef.kmm_movie.util

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

internal interface Dispatcher {
    val io: CoroutineDispatcher
}

internal expect fun providedDispatcher(): Dispatcher