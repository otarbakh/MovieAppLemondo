package com.otarbakh.movieapplemondo.ui.presentation.composables

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.otarbakh.movieapplemondo.R


@Composable
fun CustomErrorScreenSomethingHappens(
    modifier: Modifier = Modifier,
) {
    CustomEmptyStateScreen(
        modifier = modifier,
        title = stringResource(id = R.string.empty_screen_title_error_something_went_wrong),
        description = stringResource(id = R.string.empty_screen_description_error_something_went_wrong),
        image = R.drawable.background_something_wrong
    )
}


@Composable
fun CustomNoInternetConnectionScreen(
    modifier: Modifier = Modifier,
) {
    CustomEmptyStateScreen(
        modifier = modifier,
        title = stringResource(id = R.string.empty_screen_title_no_internet),
        description = stringResource(id = R.string.empty_screen_descripcion_no_internet),
        image = R.drawable.background_no_internet_connection
    )
}


@Composable
fun CustomEmptySearchScreen(
    modifier: Modifier = Modifier,
    title: String = stringResource(id = R.string.empty_screen_title_not_found_results),
    description: String = stringResource(
        id = R.string.empty_screen_description_no_results,
        "search"
    )
) {
    CustomEmptyStateScreen(
        modifier = modifier,
        title = title,
        description = description,
        image = R.drawable.background_empty_state
    )
}


