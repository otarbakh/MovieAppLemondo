package com.otarbakh.movieapplemondo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.otarbakh.movieapplemondo.presentation.navigation.RootNavigationGraph
import com.otarbakh.movieapplemondo.ui.theme.MovieAppLemondoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieAppLemondoTheme {
                RootNavigationGraph()
            }
        }
    }
}



