package com.otarbakh.movieapplemondo.ui.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import coil.compose.AsyncImage
import com.otarbakh.movieapplemondo.R
import com.otarbakh.movieapplemondo.domain.model.GenreDomain
import com.otarbakh.movieapplemondo.ui.theme.Green40
import com.otarbakh.movieapplemondo.ui.theme.PADDING_0_DP
import com.otarbakh.movieapplemondo.ui.theme.PADDING_10_DP
import com.otarbakh.movieapplemondo.ui.theme.PADDING_12_DP
import com.otarbakh.movieapplemondo.ui.theme.PADDING_140_DP
import com.otarbakh.movieapplemondo.ui.theme.PADDING_150_DP
import com.otarbakh.movieapplemondo.ui.theme.PADDING_16_DP
import com.otarbakh.movieapplemondo.ui.theme.PADDING_178_DP
import com.otarbakh.movieapplemondo.ui.theme.PADDING_20_DP
import com.otarbakh.movieapplemondo.ui.theme.PADDING_220_DP
import com.otarbakh.movieapplemondo.ui.theme.PADDING_24_DP
import com.otarbakh.movieapplemondo.ui.theme.PADDING_29_DP
import com.otarbakh.movieapplemondo.ui.theme.PADDING_2_DP
import com.otarbakh.movieapplemondo.ui.theme.PADDING_36_DP
import com.otarbakh.movieapplemondo.ui.theme.PADDING_48_DP
import com.otarbakh.movieapplemondo.ui.theme.PADDING_4_DP
import com.otarbakh.movieapplemondo.ui.theme.PADDING_54_DP
import com.otarbakh.movieapplemondo.ui.theme.PADDING_77_DP
import com.otarbakh.movieapplemondo.ui.theme.PADDING_8_DP

@Composable
fun DetailsMovieContent(
    onClickBack: () -> Unit,
    onClickFavorite: () -> Unit,
    title: String,
    description: String,
    imageBackdrop: String,
    imagePoster: String,
    genres: List<GenreDomain>,
    releaseDate: String,
    voteAverage: String,
    runtime: String,
    isFavoriteMovie: Boolean,
) {
    Column(modifier = Modifier.fillMaxSize()) {

        Spacer(modifier = Modifier.height(PADDING_10_DP))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(PADDING_36_DP)
                .padding(horizontal = PADDING_24_DP),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = androidx.compose.ui.Alignment.CenterVertically

        ) {

            Icon(
                modifier = Modifier.clickable {
                    onClickBack()
                },
                painter = painterResource(id = R.drawable.ic_arrow_left),
                contentDescription = null,
                tint = Color.Black,
            )
            Text(
                text = stringResource(R.string.details),
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight(600),
                fontFamily = FontFamily(Font(R.font.googlesans_regular, FontWeight.Normal)),
                modifier = Modifier.padding(start = PADDING_24_DP)
            )

            Icon(
                modifier = Modifier.clickable {
                    onClickFavorite()
                },
                painter = painterResource(
                    id = if (isFavoriteMovie) R.drawable.ic_love else R.drawable.ic_love_border
                ),
                contentDescription = null,
                tint = Color.Black,
            )
        }

        Spacer(modifier = Modifier.height(PADDING_20_DP))

        Box {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(PADDING_220_DP - PADDING_10_DP),
                shape = RoundedCornerShape(
                    topStart = PADDING_0_DP,
                    topEnd = PADDING_0_DP,
                    bottomEnd = PADDING_20_DP,
                    bottomStart = PADDING_20_DP
                ),
            ) {
                Box() {
                    AsyncImage(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(PADDING_220_DP - PADDING_10_DP),
                        model = imageBackdrop,
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds,
                    )
                    androidx.compose.material3.Card(
                        modifier = Modifier
                            .offset(
                                x = 2 * PADDING_150_DP + PADDING_10_DP,
                                y = PADDING_178_DP
                            )
                            .width(PADDING_54_DP)
                            .height(PADDING_24_DP)
                            .background(
                                color = Color(0x52252836),
                                shape = RoundedCornerShape(size = PADDING_8_DP)
                            )
                            .padding(
                                start = PADDING_8_DP,
                                top = PADDING_4_DP,
                                end = PADDING_8_DP,
                                bottom = PADDING_4_DP
                            ),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.Transparent
                        ),
                    ) {
                        Row() {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_favorite),
                                contentDescription = null,
                                tint = Green40,
                            )
                            Spacer(modifier = Modifier.width(PADDING_4_DP))
                            Text(
                                text = voteAverage,
                                fontSize = 12.sp,
                                fontFamily = FontFamily(Font(R.font.googlesans_regular)),
                                fontWeight = FontWeight(600),
                                color = Green40
                            )
                        }
                    }
                }
            }

            androidx.compose.material3.Card(
                modifier = Modifier
                    .offset(x = PADDING_29_DP, y = PADDING_150_DP)
                    .width(95.dp)
                    .height(PADDING_140_DP - PADDING_20_DP),
                colors = CardDefaults.cardColors(
                    containerColor = Color.Gray
                ),
                shape = RoundedCornerShape(PADDING_16_DP),
            ) {
                AsyncImage(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(PADDING_220_DP - PADDING_10_DP),
                    model = imagePoster,
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                )
            }

            Text(
                modifier = Modifier
                    .width(PADDING_220_DP - PADDING_10_DP)
                    .height(PADDING_48_DP)
                    .offset(x = PADDING_140_DP, y = PADDING_220_DP),
                text = title,
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.googlesans_regular, FontWeight.Normal)),
                fontWeight = FontWeight(600),
            )
        }

        Spacer(modifier = Modifier.height(PADDING_77_DP - PADDING_2_DP))

        HorizontalThreeOptions(
            yearRelease = releaseDate,
            duration = runtime,
            genre = if (genres.firstOrNull() == null) "" else genres.firstOrNull()?.name.toString()
        )

        Spacer(modifier = Modifier.height(PADDING_24_DP))

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = PADDING_24_DP),
            text = stringResource(R.string.description),
            fontSize = 20.sp,
            fontFamily = FontFamily(Font(R.font.googlesans_regular, FontWeight.Normal)),
            fontWeight = FontWeight(600),
        )

        Spacer(modifier = Modifier.height(PADDING_12_DP))

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = PADDING_24_DP),
            text = description,
            textAlign = TextAlign.Justify,
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(R.font.googlesans_regular, FontWeight.Normal)),
            fontWeight = FontWeight(400),
        )

        Spacer(modifier = Modifier.height(PADDING_24_DP))

        val listGenres = genres.map { it.name }.joinToString(separator = " * ")


        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = PADDING_24_DP),
            text = listGenres,
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily(Font(R.font.googlesans_regular, FontWeight.Normal)),
            fontWeight = FontWeight(600),
        )
    }
}

@Composable
fun HorizontalThreeOptions(
    yearRelease: String,
    duration: String,
    genre: String,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = PADDING_24_DP),
        horizontalArrangement = Arrangement.Center,
    ) {
        Icon(
            modifier = Modifier.size(PADDING_16_DP),
            painter = painterResource(id = R.drawable.ic_calendar),
            contentDescription = null,
            tint = Color.Gray,
        )
        Spacer(modifier = Modifier.width(PADDING_4_DP))
        Text(
            text = yearRelease,
            color = Color.Black,
            fontSize = 14.sp,
            fontWeight = FontWeight(600),
            fontFamily = FontFamily(Font(R.font.googlesans_regular, FontWeight.Normal)),
        )
        Spacer(modifier = Modifier.width(PADDING_12_DP))
        Icon(
            painter = painterResource(id = R.drawable.ic_vertical_line),
            contentDescription = null,
            tint = Color.Gray,
        )
        Spacer(modifier = Modifier.width(PADDING_12_DP))
        Icon(
            painter = painterResource(id = R.drawable.ic_clock),
            contentDescription = null,
            tint = Color.Gray,
        )
        Spacer(modifier = Modifier.width(PADDING_4_DP))
        Text(
            text = duration,
            color = Color.Black,
            fontSize = 14.sp,
            fontWeight = FontWeight(600),
            fontFamily = FontFamily(Font(R.font.googlesans_regular, FontWeight.Normal)),
        )
        Spacer(modifier = Modifier.width(PADDING_12_DP))
        Icon(
            painter = painterResource(id = R.drawable.ic_vertical_line),
            contentDescription = null,
            tint = Color.Gray,
        )
        Spacer(modifier = Modifier.width(PADDING_12_DP))
        Icon(
            painter = painterResource(id = R.drawable.ic_ticket),
            contentDescription = null,
            tint = Color.Gray,
        )
        Spacer(modifier = Modifier.width(PADDING_4_DP))
        Text(
            text = genre,
            color = Color.Black,
            fontSize = 14.sp,
            fontWeight = FontWeight(600),
            fontFamily = FontFamily(Font(R.font.googlesans_regular, FontWeight.Normal)),
        )
    }
}
