package com.otarbakh.movieapplemondo.ui.presentation.navigation

sealed class DetailsScreen(val route: String) {
    object Information : DetailsScreen("information_screen")
}