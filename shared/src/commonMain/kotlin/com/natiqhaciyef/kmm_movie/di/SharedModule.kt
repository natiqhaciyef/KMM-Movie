package com.natiqhaciyef.kmm_movie.di

import com.natiqhaciyef.kmm_movie.data.network.config.MovieService
import com.natiqhaciyef.kmm_movie.data.repository.MovieRepositoryImpl
import com.natiqhaciyef.kmm_movie.data.source.NetworkDataSource
import com.natiqhaciyef.kmm_movie.domain.repository.MovieRepository
import com.natiqhaciyef.kmm_movie.domain.usecase.GetAllMoviesUseCase
import com.natiqhaciyef.kmm_movie.domain.usecase.GetMovieUseCase
import com.natiqhaciyef.kmm_movie.util.providedDispatcher
import org.koin.dsl.module


private val dataModule = module {
    factory { NetworkDataSource(get(),get()) }
    factory { MovieService() }
}

private val utilModule = module {
    factory { providedDispatcher() }
}

private val domainModule = module {
    factory { GetMovieUseCase() }
    factory { GetAllMoviesUseCase() }
    single<MovieRepository> { MovieRepositoryImpl(get()) }
}

private val sharedModule = listOf(dataModule, utilModule, domainModule)

fun getSharedModules() = sharedModule