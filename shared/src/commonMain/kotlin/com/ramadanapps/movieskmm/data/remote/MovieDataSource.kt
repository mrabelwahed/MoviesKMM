package com.ramadanapps.movieskmm.data.remote

import com.ramadanapps.movieskmm.util.Dispatcher
import kotlinx.coroutines.withContext

internal class MovieDataSource (private val movieService: MovieService, private val dispatcher: Dispatcher){

    suspend fun getMovies(page: Int) : MoviesResponse = withContext(dispatcher.io) {
         movieService.getMovies(page = page)
    }

    suspend fun getMovie(movieID:Int): MovieRemote = withContext(dispatcher.io){
         movieService.getMovieByID(movieID)
    }
}