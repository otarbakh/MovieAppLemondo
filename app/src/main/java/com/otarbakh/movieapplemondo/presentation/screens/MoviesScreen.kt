package com.otarbakh.movieapplemondo.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.otarbakh.movieapplemondo.R
import com.otarbakh.movieapplemondo.domain.MovieDomain
import com.otarbakh.movieapplemondo.presentation.composables.CustomEmptySearchScreen
import com.otarbakh.movieapplemondo.presentation.composables.CustomErrorScreenSomethingHappens
import com.otarbakh.movieapplemondo.presentation.composables.CustomNoInternetConnectionScreen
import com.otarbakh.movieapplemondo.presentation.composables.HorizontalMovieItem
import com.otarbakh.movieapplemondo.presentation.composables.LoadingScreen
import com.otarbakh.movieapplemondo.usecases.PopularMoviesResult

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoviesScreen(
    moviesList: PopularMoviesResult,
    onClickNavigateToDetails: (Int) -> Unit,
    onQueryChange: (String) -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {

        var searchQuery by rememberSaveable { mutableStateOf("") }

        Spacer(modifier = Modifier.height(16.dp))
        SearchBar(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .height(70.dp)
                .clip(RoundedCornerShape(40.dp)),
            query = searchQuery,
            onQueryChange = { queryChanged ->
                searchQuery = queryChanged
                onQueryChange(queryChanged)
            },
            onSearch = { query ->
            },
            active = true,
            onActiveChange = { isActive ->
            },
            placeholder = { Text("Search Movie") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },

            ) {

        }

        Spacer(modifier = Modifier.height(16.dp))

        HeaderMoviesScreen(
            searchQuery = searchQuery,
            onClickNavigateToDetails = onClickNavigateToDetails,
            popularMoviesState = moviesList
        )
    }
}

@Composable
fun HeaderMoviesScreen(
    searchQuery: String,
    onClickNavigateToDetails: (Int) -> Unit,
    popularMoviesState: PopularMoviesResult
) {
    var isErrorGeneral by rememberSaveable { mutableStateOf(false) }
    var isSuccess by rememberSaveable { mutableStateOf(false) }
    var isLoading by rememberSaveable { mutableStateOf(false) }
    var isEmpty by rememberSaveable { mutableStateOf(false) }
    var isInternetError by rememberSaveable { mutableStateOf(false) }

    var popularMoviesList by rememberSaveable { mutableStateOf(listOf<MovieDomain>()) }

    LaunchedEffect(key1 = popularMoviesState) {
        when (popularMoviesState) {
            PopularMoviesResult.Empty -> {
                isLoading = false
                isErrorGeneral = false
                isInternetError = false
                isEmpty = true
            }

            is PopularMoviesResult.ErrorGeneral -> {
                isLoading = false
                isErrorGeneral = true
            }

            PopularMoviesResult.InternetError -> {
                isErrorGeneral = false
            }

            is PopularMoviesResult.Loading -> {
                isLoading = popularMoviesState.isLoading
                isErrorGeneral = false
            }

            is PopularMoviesResult.Success -> {
                isLoading = false
                isErrorGeneral = false
                isEmpty = false
                isInternetError = false
                isSuccess = true
                popularMoviesList = popularMoviesState.list
            }
        }
    }

    when {
        isLoading -> {
            LoadingScreen()
        }

        isErrorGeneral -> {
            CustomErrorScreenSomethingHappens(
                modifier = Modifier.padding(bottom = 180.dp),
            )
        }

        isInternetError -> {
            CustomNoInternetConnectionScreen(
                modifier = Modifier.padding(bottom = 180.dp),
            )
        }

        isEmpty -> {
            CustomEmptySearchScreen(
                Modifier.padding(bottom = 180.dp),
                description = stringResource(
                    id = R.string.empty_screen_description_no_results,
                    searchQuery
                )
            )
        }

        isSuccess -> {
            LazyColumn(
                content = {
                    items(popularMoviesList) {

                        HorizontalMovieItem(
                            title = it.title,
                            description = it.overview,
                            imageUrl = it.poster_path,
                            rating = it.vote_average,
                            realeaseDate = it.release_date ?: "",
                            onClick = { onClickNavigateToDetails(it.id) })

                        if (it == popularMoviesList.last()) {
                            Spacer(modifier = Modifier.height(80.dp))
                        }
                    }
                })
        }
    }
}
