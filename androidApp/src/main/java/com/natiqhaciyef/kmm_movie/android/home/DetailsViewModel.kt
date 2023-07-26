package com.natiqhaciyef.kmm_movie.android.home

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.natiqhaciyef.kmm_movie.android.details.DetailsScreenState
import com.natiqhaciyef.kmm_movie.domain.usecase.GetMovieUseCase
import kotlinx.coroutines.launch

class DetailsViewModel(
    private val getMovieUseCase: GetMovieUseCase,
    val movieId: Int,
): ViewModel() {
    var detailsUIState by mutableStateOf(DetailsScreenState())

    init {
        loadMovie(movieId)
    }

    private fun loadMovie(movieId: Int){
        viewModelScope.launch {
            detailsUIState.isLoading = true
            detailsUIState.movie = getMovieUseCase.invoke(movieId)
            detailsUIState.isLoading = false
        }
    }
}
