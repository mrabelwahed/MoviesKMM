package com.ramadanapps.movieskmm.data.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

internal data class MoviesResponse(val movies: List<MovieRemote>)

@Serializable
internal data class MovieRemote(
    val id: Int,
    val title: String,
    val overview: String,
    val posterImage: String,
    @SerialName("release_date")
    val releaseDate: String
)