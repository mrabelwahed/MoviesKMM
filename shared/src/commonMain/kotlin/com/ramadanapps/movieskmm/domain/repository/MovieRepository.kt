package com.ramadanapps.movieskmm.domain.repository

import com.ramadanapps.movieskmm.domain.model.Movie

internal interface MovieRepository {
  suspend fun getMovies(page: Int): List<Movie>
  suspend fun getMovieByID(movieID: Int): Movie
}