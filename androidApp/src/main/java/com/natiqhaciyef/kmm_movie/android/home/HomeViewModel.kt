package com.natiqhaciyef.kmm_movie.android.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.natiqhaciyef.kmm_movie.domain.usecase.GetAllMoviesUseCase
import kotlinx.coroutines.launch

class HomeViewModel(
    val getAllMoviesUseCase: GetAllMoviesUseCase
) : ViewModel() {
    var uiState by mutableStateOf(HomeScreenState())
    private var currentPage = 1

    init {
        loadingMovies(false)
    }

    fun loadingMovies(forceReload: Boolean = false) {
        if (uiState.loading) return
        if (forceReload)
            currentPage = 1

        if (currentPage == 1)
            uiState = uiState.copy(refreshing = true)

        viewModelScope.launch {
            uiState = uiState.copy(loading = true)

            try {
                val moviesList = getAllMoviesUseCase.invoke(page = currentPage)
                val movies =
                    if (currentPage != 1)
                    uiState.movies + moviesList
                else
                    moviesList

                currentPage += 1
                uiState = uiState.copy(
                    loading = false,
                    refreshing = false,
                    loadFinished = moviesList.isEmpty(),
                    movies = movies
                )
            } catch (error: Throwable) {
                uiState = uiState.copy(
                    loading = false,
                    refreshing = false,
                    loadFinished = true,
                    errorMessage = "Loading failed: ${error.localizedMessage}"
                )
            }
        }
    }
}