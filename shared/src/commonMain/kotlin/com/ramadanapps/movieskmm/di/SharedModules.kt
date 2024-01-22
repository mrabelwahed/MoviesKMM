package com.ramadanapps.movieskmm.di

import com.ramadanapps.movieskmm.data.remote.MovieDataSource
import com.ramadanapps.movieskmm.data.remote.MovieService
import com.ramadanapps.movieskmm.data.repository.MovieRepositoryImpl
import com.ramadanapps.movieskmm.domain.repository.MovieRepository
import com.ramadanapps.movieskmm.domain.usecase.GetMovieUseCase
import com.ramadanapps.movieskmm.domain.usecase.GetMoviesUseCase
import com.ramadanapps.movieskmm.util.provideDispatcher
import org.koin.dsl.module


private val dataModule = module {
    factory { MovieDataSource(get(),get()) }
    factory { MovieService() }
}

private val utilityModule = module {
    factory { provideDispatcher() }
}

private val domainModule = module {
    single<MovieRepository> { MovieRepositoryImpl(get()) }
    factory { GetMovieUseCase() }
    factory { GetMoviesUseCase() }
}

private val sharedModules = listOf(dataModule, utilityModule, domainModule)

fun getSharedModules() = sharedModules