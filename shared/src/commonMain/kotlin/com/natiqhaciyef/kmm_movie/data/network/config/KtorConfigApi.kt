package com.natiqhaciyef.kmm_movie.data.network.config

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.parameter
import io.ktor.http.path
import io.ktor.http.takeFrom
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


private const val BASE_URL = "https://api.themoviedb.org/"
private const val API_KEY = "810d36e80428b972d893f7a52a4fd6d7"
// api key -> 810d36e80428b972d893f7a52a4fd6d7
// https://api.themoviedb.org/3/movie/157336?api_key=810d36e80428b972d893f7a52a4fd6d7
// https://api.themoviedb.org/3/movie/popular?language=en-US&page=1&api_key=810d36e80428b972d893f7a52a4fd6d7



internal abstract class KtorConfigApi {
    val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
        }
    }

    fun HttpRequestBuilder.pathUrl(path: String){
        url {
            takeFrom(BASE_URL)
            path("3",path)
            parameter("api_key", API_KEY)
        }
    }
}