package fi.developer.designpattern_android.presentation.viewmodel.coin_list

import fi.developer.designpattern_android.domain.model.CoinsDetailsResponse
import fi.developer.designpattern_android.domain.model.CoinsResponseItem

data class CoinsViewState(
    val isLoading: Boolean = false,
    val coins: List<CoinsResponseItem> = emptyList(),
    val coinDetails: CoinsDetailsResponse? = null,
    val error: String? = null,
    val selectedCoinId: String? = null
)