package com.ramadanapps.movieskmm.domain.usecase

import com.ramadanapps.movieskmm.domain.model.Movie
import com.ramadanapps.movieskmm.domain.repository.MovieRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetMoviesUseCase: KoinComponent {
   private val repository: MovieRepository by inject()

    @Throws(Exception::class)
    suspend operator fun invoke(page: Int): List<Movie> {
        return repository.getMovies(page)
    }
}