package com.natiqhaciyef.kmm_movie.data.network.config

import com.natiqhaciyef.kmm_movie.data.network.responses.MoviesListResponse
import com.natiqhaciyef.kmm_movie.data.network.responses.MoviesResponse
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

internal class MovieService : KtorConfigApi(){

    suspend fun getAllMovies(page: Int = 1): MoviesListResponse = client.get{
        pathUrl("movie/popular")
        parameter("page",page)
    }.body()

    suspend fun getMovie(movieId: Int): MoviesResponse = client.get{
        pathUrl("movie/${movieId}")
    }.body()
}