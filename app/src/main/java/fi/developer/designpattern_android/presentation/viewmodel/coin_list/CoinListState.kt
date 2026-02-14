package fi.developer.designpattern_android.presentation.viewmodel.coin_list

import fi.developer.designpattern_android.domain.model.CoinsResponseItem

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<CoinsResponseItem> = emptyList(),
    val error: String = ""
)