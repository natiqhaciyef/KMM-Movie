package com.natiqhaciyef.kmm_movie.android.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.natiqhaciyef.kmm_movie.android.*
import com.natiqhaciyef.kmm_movie.android.details.HomeScreenState
import com.natiqhaciyef.kmm_movie.domain.models.MovieModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    uiState: HomeScreenState,
    loadNextMovies: (Boolean) -> Unit = {},
    navigateToDetails: (MovieModel) -> Unit,
) {

    val pullRefreshState = rememberPullRefreshState(
        refreshing = uiState.refreshing,
        onRefresh = { loadNextMovies.invoke(true) }
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Dark4)
            .pullRefresh(pullRefreshState)
    ) {
        Text(
            modifier = modifier
                .fillMaxWidth()
                .padding(25.dp),
            text = "Movies",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.White,
            textAlign = TextAlign.Start
        )

        Box(
            modifier = Modifier.fillMaxWidth()
        ) {

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(15.dp),
                verticalArrangement = Arrangement.spacedBy(15.dp),
                horizontalArrangement = Arrangement.spacedBy(15.dp)
            ) {

                itemsIndexed(
                    items = uiState.movies,
                    key = { _, movie -> movie.id }
                ) { index, movie ->
                    MovieItemView(movieModel = movie) {
                        navigateToDetails(it)
                    }

                    if (index >= uiState.movies.size - 1 && !uiState.loading && !uiState.loadFinished) {
                        LaunchedEffect(key1 = Unit, block = {
                            loadNextMovies.invoke(false)
                        })
                    }
                }

                if (uiState.loading && uiState.movies.isNotEmpty()) {
                    item(span = { GridItemSpan(2) }) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(20.dp),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            CircularProgressIndicator(color = Red)
                        }
                    }
                }
            }

            PullRefreshIndicator(
                refreshing = uiState.refreshing, state = pullRefreshState,
                modifier = modifier.align(Alignment.TopCenter)
            )
        }
    }
}


@Composable
fun MovieItemView(
    movieModel: MovieModel,
    modifier: Modifier = Modifier,
    onClickAction: (MovieModel) -> Unit
) {
    Card(
        modifier = modifier
            .height(220.dp)
            .clickable {
                onClickAction.invoke(movieModel)
            },
        shape = RoundedCornerShape(8.dp)
    ) {
        Column {
            Box(
                modifier = modifier.weight(1f),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = movieModel.imageUrl,
                    contentDescription = movieModel.title,
                    contentScale = ContentScale.Crop,
                    modifier = modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(bottomStart = 2.dp, bottomEnd = 2.dp))
                )
            }
        }

    }

}