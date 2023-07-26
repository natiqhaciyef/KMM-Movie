package com.natiqhaciyef.kmm_movie.android.di

import com.natiqhaciyef.kmm_movie.android.home.DetailsViewModel
import com.natiqhaciyef.kmm_movie.android.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { parametersHolder ->
        DetailsViewModel(
            get(),
            movieId = parametersHolder.get()
        )
    }
}


