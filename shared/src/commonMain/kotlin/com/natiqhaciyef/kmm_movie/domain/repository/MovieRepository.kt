package com.natiqhaciyef.kmm_movie.domain.repository

import com.natiqhaciyef.kmm_movie.domain.models.MovieModel

internal interface MovieRepository {

    suspend fun getMovies(page: Int): List<MovieModel>

    suspend fun getMovieById(id: Int): MovieModel


}