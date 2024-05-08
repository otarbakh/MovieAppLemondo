package com.otarbakh.movieapplemondo.ui.presentation.navigation

import com.otarbakh.movieapplemondo.R

sealed class HomeScreen(val route: String, val icon: Int, val title: String) {
    object MoviesHomeScreen : HomeScreen("movies_screen", R.drawable.ic_movie, "Movies")
    object FavoritesHomeScreen : HomeScreen("favorites_screen", R.drawable.ic_love, "Favorites")
}