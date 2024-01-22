package com.ramadanapps.movieskmm.android

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ramadanapps.movieskmm.android.home.HomeScreen
import com.ramadanapps.movieskmm.android.home.HomeViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainScreen (navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home"){
        composable("home"){
            val viewModel: HomeViewModel = koinViewModel()
            HomeScreen(
                state = viewModel.uiState,
                loadNextMovies = {viewModel.loadMovies()} ,
                navigateToDetails = {}
            )
        }
    }
}