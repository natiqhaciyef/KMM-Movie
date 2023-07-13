package com.natiqhaciyef.kmm_movie.util

import com.natiqhaciyef.kmm_movie.di.getSharedModules
import org.koin.core.context.startKoin


fun initKoin(){
    startKoin {
        modules(getSharedModules())
    }
}