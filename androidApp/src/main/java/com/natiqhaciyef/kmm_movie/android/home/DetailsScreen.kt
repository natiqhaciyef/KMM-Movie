package com.natiqhaciyef.kmm_movie.android.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.natiqhaciyef.kmm_movie.android.R
import com.natiqhaciyef.kmm_movie.android.details.DetailsScreenState
import com.natiqhaciyef.kmm_movie.domain.models.MovieModel


@Composable
fun DetailsScreen(
    modifier: Modifier = Modifier,
    uiState: DetailsScreenState
) {

    Box(
        modifier = modifier, contentAlignment = Alignment.Center
    ) {
        uiState.movie?.let { movie ->

            Column(
                modifier = modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colors.background)
            ) {

                AsyncImage(
                    model = movie.imageUrl,
                    contentDescription = "Movie",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(320.dp)
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(20.dp)
                ) {
                    Text(
                        modifier = modifier,
                        text = movie.title,
                        style = MaterialTheme.typography.h5,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(
                        modifier = modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        onClick = {},
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.Red
                        ),
                        elevation = ButtonDefaults.elevation(2.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.play_button),
                            contentDescription = "Icon",
                            modifier = modifier,
                            tint = Color.White
                        )

                        Spacer(modifier = modifier.width(10.dp))

                        Text(
                            text = "Start watching!",
                            color = Color.White
                        )
                    }

                    Spacer(modifier = modifier.height(20.dp))
                    Text(
                        text = "Released in ${movie.releaseDate}".uppercase(),
                        color = Color.White,
                        style = MaterialTheme.typography.overline
                    )
                    Spacer(modifier = modifier.height(5.dp))
                    Text(
                        text = movie.description,
                        color = Color.White,
                        style = MaterialTheme.typography.body2
                    )
                }
            }
        }

        if (uiState.isLoading) {
            Row(
                modifier = modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                CircularProgressIndicator(color = Color.Red)
            }
        }
    }
}