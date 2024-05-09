package com.otarbakh.movieapplemondo.ui.presentation.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.otarbakh.movieapplemondo.R
import com.otarbakh.movieapplemondo.core.extensions.toFormattedDateString
import com.otarbakh.movieapplemondo.ui.theme.PADDING_150_DP
import com.otarbakh.movieapplemondo.ui.theme.PADDING_16_DP
import com.otarbakh.movieapplemondo.ui.theme.PADDING_4_DP
import com.otarbakh.movieapplemondo.ui.theme.PADDING_8_DP


@Composable
fun HorizontalMovieItem(
    title: String,
    description: String,
    rating: Float,
    imageUrl: String,
    realeaseDate: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(
                horizontal = PADDING_16_DP,
                vertical = PADDING_8_DP
            ),
        shape = RoundedCornerShape(PADDING_16_DP),
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Card(
                modifier = Modifier
                    .height(PADDING_150_DP)
                    .align(CenterVertically)
                    .fillMaxWidth(0.3f),
                shape = RoundedCornerShape(0.dp),
            ) {
                Column(
                    horizontalAlignment = CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    AsyncImage(
                        model = imageUrl,
                        contentDescription = null,
                    )
                }
            }

            Column(
                modifier = Modifier
                    .padding(PADDING_16_DP)
                    .fillMaxWidth()
            ) {
                Text(
                    text = title,
                    maxLines = 1,
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(PADDING_8_DP))
                Text(
                    text = stringResource(R.string.release_date),
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(PADDING_4_DP))

                Text(text = (realeaseDate.toFormattedDateString()))

                Spacer(modifier = Modifier.height(PADDING_8_DP))
            }
        }
    }
}
