package com.ramadanapps.movieskmm.android.home

import androidx.compose.runtime.ProvidedValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ramadanapps.movieskmm.domain.model.Movie
import com.ramadanapps.movieskmm.domain.usecase.GetMoviesUseCase
import kotlinx.coroutines.launch

class HomeViewModel(private val getMoviesUseCase: GetMoviesUseCase): ViewModel() {
    var uiState by mutableStateOf(HomeScreenState())
    private var currentPage = 1

    init {
        loadMovies()
    }

    fun loadMovies(forceToLoad: Boolean = false) {
        if (uiState.loading) return
        if (forceToLoad) currentPage = 1
        if (currentPage == 1) uiState = uiState.copy(refreshing = true)

        viewModelScope.launch {
            uiState = uiState.copy(loading = true)
            try {
                val result = getMoviesUseCase(currentPage)
                val movies = if (currentPage == 1) result else uiState.movies + result
                currentPage += 1
                uiState = uiState.copy(
                    loading = false,
                    refreshing = false,
                    loadFinished = result.isEmpty(),
                    movies = movies
                )

            }catch (e:Exception) {
                uiState = uiState.copy(
                    loading = false,
                    refreshing = false,
                    loadFinished = true,
                    error = "Could not load Movies: ${e.localizedMessage}"
                )
            }
        }

    }
}


data class HomeScreenState(
    val loading: Boolean = false,
    val movies: List<Movie> = emptyList(),
    val error: String? = null,
    val refreshing: Boolean = false,
    val loadFinished: Boolean = false
)