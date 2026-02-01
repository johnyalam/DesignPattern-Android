package fi.developer.designpattern_android.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import fi.developer.designpattern_android.ui.screen.AboutScreen
import fi.developer.designpattern_android.ui.screen.HomeScreen
import fi.developer.designpattern_android.ui.screen.SettingsScreen

@Composable
fun NavigationStack() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(
            route = Screen.Home.route,
        ) {
            HomeScreen(navController)
        }

        composable(
            route = Screen.Settings.route,
        ) {
            SettingsScreen(navController)
        }

        composable(
            route = Screen.About.route,
        ) {
            AboutScreen(navController)
        }

    }

}