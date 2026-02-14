package fi.developer.designpattern_android.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import fi.developer.designpattern_android.presentation.ui.screen.CoinDetailScreen
import fi.developer.designpattern_android.presentation.ui.screen.CoinListScreen

@Composable
fun NavigationStack() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.CoinListScreen.route) {
        composable(
            route = Screen.CoinListScreen.route,
        ) {
            CoinListScreen(navController)
        }

        composable(
            route = Screen.CoinDetailScreen.route + "/{coinId}",
        ) {
            CoinDetailScreen()
        }
    }

}