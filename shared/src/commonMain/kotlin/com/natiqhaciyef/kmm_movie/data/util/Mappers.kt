package com.natiqhaciyef.kmm_movie.data.util

import com.natiqhaciyef.kmm_movie.data.network.responses.MoviesResponse
import com.natiqhaciyef.kmm_movie.domain.models.MovieModel

internal fun MoviesResponse.toMovie(): MovieModel{
    return MovieModel(
        id = this.id,
        title = this.originalTitle,
        description = this.overview,
        imageUrl = this.posterImage,
        releaseDate = this.releaseDate
    )
}

private fun getImageUrL(image: String) = "https://image.tmdb.org/t/p/w500/${image}"