package com.natiqhaciyef.kmm_movie.data.network.responses

import kotlinx.serialization.Serializable

@Serializable
internal data class MoviesListResponse(
    val results: List<MoviesResponse>
)
