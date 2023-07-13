package com.natiqhaciyef.kmm_movie.data.repository

import com.natiqhaciyef.kmm_movie.data.source.NetworkDataSource
import com.natiqhaciyef.kmm_movie.data.util.toMovie
import com.natiqhaciyef.kmm_movie.domain.models.MovieModel
import com.natiqhaciyef.kmm_movie.domain.repository.MovieRepository

internal class MovieRepositoryImpl(
    private val nds: NetworkDataSource
) : MovieRepository {
    override suspend fun getMovies(page: Int): List<MovieModel> {
        return nds.getAllMovies(page).results.map {
            it.toMovie()
        }
    }

    override suspend fun getMovieById(movieId: Int): MovieModel {
        return nds.getMovie(movieId).toMovie()
    }
}