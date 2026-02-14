package fi.developer.designpattern_android.presentation.ui.navigation

import fi.developer.designpattern_android.core.Constants.COIN_DETAILS_SCREEN
import fi.developer.designpattern_android.core.Constants.COIN_LIST_SCREEN
import fi.developer.designpattern_android.core.Constants.HOME_SCREEN

sealed class Screen(val route: String) {
    object CoinListScreen : Screen(COIN_LIST_SCREEN)
    object CoinDetailScreen : Screen(COIN_DETAILS_SCREEN)
}