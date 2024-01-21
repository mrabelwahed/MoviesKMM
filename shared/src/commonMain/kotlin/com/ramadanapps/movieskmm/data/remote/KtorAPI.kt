package com.ramadanapps.movieskmm.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.parameter
import io.ktor.http.path
import io.ktor.http.takeFrom
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

private const val BASE_URL = "https://api.themoviedb.org/"
private const val API_KEY = "0e0a3b6bc9d6229c038c5e81b1a6e6d7"
internal abstract  class KtorAPI {
    val client = HttpClient {
        install(ContentNegotiation){
            json(
               json = Json {
                   ignoreUnknownKeys = true
                   useAlternativeNames = true
               }
            )
        }
    }


    fun HttpRequestBuilder.pathUrl(path: String) {
        url {
            takeFrom(BASE_URL)
            path("3", path) //version3 of TMDB
            parameter("api_key", API_KEY,)
        }
    }
}