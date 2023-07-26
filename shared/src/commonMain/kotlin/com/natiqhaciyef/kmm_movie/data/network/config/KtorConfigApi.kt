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
private const val API_KEY = "5295d7b3effd5e4c9deedbcb3c4d2082"
// api key -> 5295d7b3effd5e4c9deedbcb3c4d2082
// eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI1Mjk1ZDdiM2VmZmQ1ZTRjOWRlZWRiY2IzYzRkMjA4MiIsInN1YiI6IjY0YzE4MWU0MmYxYmUwMDBjYTI2ZmNhNCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.1kqAD5-_7g33pQIOjrxSqg8q6nJeK1UR9eaDZGOq6jQ
// https://api.themoviedb.org/3/movie/157336?api_key=810d36e80428b972d893f7a52a4fd6d7
// https://api.themoviedb.org/3/movie/popular?language=en-US&page=1&api_key=5295d7b3effd5e4c9deedbcb3c4d2082



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