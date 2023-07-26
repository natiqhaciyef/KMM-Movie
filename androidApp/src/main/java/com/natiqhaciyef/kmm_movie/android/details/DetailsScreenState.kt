package com.natiqhaciyef.kmm_movie.android.details

import com.natiqhaciyef.kmm_movie.domain.models.MovieModel

data class DetailsScreenState(
    var movie: MovieModel? = null,
    var errorMessage: String? = null,
    var isLoading: Boolean = false
)
