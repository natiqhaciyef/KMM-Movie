package com.natiqhaciyef.kmm_movie.android.common

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.natiqhaciyef.kmm_movie.android.home.DetailsScreen
import com.natiqhaciyef.kmm_movie.android.home.HomeScreen
import com.natiqhaciyef.kmm_movie.android.home.HomeViewModel
import com.natiqhaciyef.millisoft_compose.common.ScreenId
import org.koin.androidx.compose.koinViewModel

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = ScreenId.HomeScreen.name) {

        composable(route = ScreenId.HomeScreen.name) {
            val homeViewModel: HomeViewModel = koinViewModel()
            HomeScreen(uiState = homeViewModel.uiState, loadNextMovies = {
                homeViewModel.loadingMovies(forceReload = it)
            },
            navigateToDetails = {
                navController.navigate("${ScreenId.DetailsScreen.name}/${it.id}")
            })
        }

        composable(
            route = "${ScreenId.DetailsScreen.name}/{id}",
            arguments = listOf(
                navArgument(name = "id") {
                    type = NavType.IntType
                }
            )
        ) {
            val id = it.arguments?.getInt("id") ?: 0
            DetailsScreen(id)
        }

    }

}