package com.ramadanapps.movieskmm.data.remote

import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.url

internal class MovieService: KtorApi() {
    suspend fun getMovies(page: Int = 1): MoviesResponse = client.get {
        pathUrl("movie/popular")
        parameter("page", page)
    }.body()

    suspend fun getMovieByID(movieId: Int): MovieRemote = client.get {
        pathUrl("movie/${movieId}")
    }.body()

}