package com.natiqhaciyef.kmm_movie.data.source

import com.natiqhaciyef.kmm_movie.data.network.config.MovieService
import com.natiqhaciyef.kmm_movie.util.Dispatcher
import kotlinx.coroutines.withContext

internal class NetworkDataSource(
    private val apiService: MovieService,
    private val dispatcher: Dispatcher
) {

    suspend fun getAllMovies(page: Int) = withContext(dispatcher.io){
        apiService.getAllMovies(page)
    }

    suspend fun getMovie(movieId: Int) = withContext(dispatcher.io){
        apiService.getMovie(movieId = movieId)
    }
}