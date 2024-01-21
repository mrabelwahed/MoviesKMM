package com.ramadanapps.movieskmm.domain.usecase

import com.ramadanapps.movieskmm.domain.model.Movie
import com.ramadanapps.movieskmm.domain.repository.MovieRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetMovieUseCase: KoinComponent {
    private val repository: MovieRepository by inject()

    @Throws(Exception::class)
    suspend operator fun invoke(movieID: Int): Movie {
        return repository.getMovieByID(movieID)
    }
}