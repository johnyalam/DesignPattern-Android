package fi.developer.designpattern_android.presentation.viewmodel.coin_list

sealed class CoinsIntent {
    object LoadCoins : CoinsIntent()
    data class LoadCoinDetails(val coinId: String) : CoinsIntent()
    object Retry : CoinsIntent()
}
