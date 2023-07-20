package com.natiqhaciyef.kmm_movie.domain.usecase

import com.natiqhaciyef.kmm_movie.domain.models.MovieModel
import com.natiqhaciyef.kmm_movie.domain.repository.MovieRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetAllMoviesUseCase : KoinComponent{

    private val repository: MovieRepository by inject()

    @Throws(Exception::class)
    suspend operator fun invoke(page: Int): List<MovieModel> {
        return repository.getMovies(page)
    }

}