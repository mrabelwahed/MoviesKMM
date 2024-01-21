package com.ramadanapps.movieskmm.data.repository

import com.ramadanapps.movieskmm.data.remote.MovieDataSource
import com.ramadanapps.movieskmm.data.util.toMovie
import com.ramadanapps.movieskmm.domain.model.Movie
import com.ramadanapps.movieskmm.domain.repository.MovieRepository

internal class MovieRepositoryImpl(private val movieDataSource: MovieDataSource): MovieRepository {

    override suspend fun getMovies(page: Int): List<Movie> {
        return movieDataSource.getMovies(page).movies.map {
            it.toMovie()
        }
    }

    override suspend fun getMovieByID(movieID: Int): Movie {
        return movieDataSource.getMovie(movieID).toMovie()
    }
}