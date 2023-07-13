package com.natiqhaciyef.kmm_movie.domain.usecase

import com.natiqhaciyef.kmm_movie.domain.models.MovieModel
import com.natiqhaciyef.kmm_movie.domain.repository.MovieRepository
import kotlinx.coroutines.flow.flow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

internal class GetMovieUseCase : KoinComponent{

    private val repository: MovieRepository by inject()

    @Throws(Exception::class)
    suspend operator fun invoke(movieId: Int): MovieModel {
        return repository.getMovieById(movieId)
    }
}