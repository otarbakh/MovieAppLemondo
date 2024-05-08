package com.otarbakh.movieapplemondo.ui.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.otarbakh.movieapplemondo.R
import com.otarbakh.movieapplemondo.ui.presentation.screens.DetailsMovieScreen
import com.otarbakh.movieapplemondo.ui.presentation.screens.FavoritesScreen
import com.otarbakh.movieapplemondo.ui.presentation.screens.MoviesScreen
import com.otarbakh.movieapplemondo.ui.presentation.screens.DashboardScreen
import com.otarbakh.movieapplemondo.ui.presentation.viewmodels.DetailsMovieViewModel
import com.otarbakh.movieapplemondo.ui.presentation.viewmodels.FavoritesViewModel
import com.otarbakh.movieapplemondo.ui.presentation.viewmodels.MoviesViewModel
import timber.log.Timber


@Composable
fun RootNavigationGraph(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        route = NavGraph.ROOT,
        startDestination = NavGraph.HOME
    ) {
        composable(route = NavGraph.HOME) {
            DashboardScreen()
        }

        composable(route = NavGraph.DETAILS) {
            
        }

    }
}


@Composable
fun homeNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = NavGraph.HOME,
        startDestination = HomeScreen.MoviesHomeScreen.route,
    ) {

        composable(HomeScreen.MoviesHomeScreen.route) {
            val moviesViewModel = hiltViewModel<MoviesViewModel>()
            val moviesState by moviesViewModel.movies.collectAsStateWithLifecycle()
            MoviesScreen(
                moviesList = moviesState,
                onClickNavigateToDetails = { movieID ->
                    Timber.d("movieId saved: $movieID")
                    navController.navigate(route = NavGraph.DETAILS + "/$movieID")
                },
                onQueryChange = { query ->
                    moviesViewModel.searchMovieOrEmpty(query)
                }
            )
        }
        composable(HomeScreen.FavoritesHomeScreen.route) {

            val favoritesViewModel = hiltViewModel<FavoritesViewModel>()
            val favoriteMovies by favoritesViewModel.favoriteMovies.collectAsStateWithLifecycle()

            FavoritesScreen(
                onClickNavigateToDetails = { movieID ->
                    navController.navigate(route = NavGraph.DETAILS + "/$movieID")
                },
                favoriteMovies = favoriteMovies
            )
        }
        detailsNavGraph(navController = navController)
    }
}


fun NavGraphBuilder.detailsNavGraph(navController: NavHostController) {
    navigation(
        route = NavGraph.DETAILS + "/{movieId}",
        startDestination = DetailsScreen.Information.route
    ) {

        composable(DetailsScreen.Information.route) {
            val movieId = it.arguments?.getString("movieId") ?: ""
            val detailsMovieViewModel = hiltViewModel<DetailsMovieViewModel>()
            val stateMovieDetail by detailsMovieViewModel.detailsMovie.collectAsStateWithLifecycle()
            val isFavoriteMovie by detailsMovieViewModel.isFavoriteMovie.collectAsStateWithLifecycle()
            Timber.d("movieId retrieved: ${movieId}")

            DetailsMovieScreen(
                navController = navController,
                stateMovieDetail = stateMovieDetail,
                onClickFavorite = { movieDetail ->
                    detailsMovieViewModel.saveOrRemoveFavoriteMovie(movieDetail)
                },
                isFavoriteMovie = isFavoriteMovie,
            )
        }
    }


}







