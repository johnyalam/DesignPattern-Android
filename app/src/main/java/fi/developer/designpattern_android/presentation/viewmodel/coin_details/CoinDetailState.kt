package fi.developer.designpattern_android.presentation.viewmodel.coin_details

import fi.developer.designpattern_android.domain.model.CoinsDetailsResponse

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinsDetailsResponse ? = null,
    val error: String = ""
)