package com.natiqhaciyef.kmm_movie.android.details

import com.natiqhaciyef.kmm_movie.domain.models.MovieModel

data class HomeScreenState(
    var loading: Boolean = false,
    var refreshing: Boolean = false,
    var movies: List<MovieModel> = listOf(),
    var errorMessage: String? = null,
    var loadFinished: Boolean = false
)
