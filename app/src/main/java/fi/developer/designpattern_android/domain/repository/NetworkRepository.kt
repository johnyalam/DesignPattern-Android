package fi.developer.designpattern_android.domain.repository


import fi.developer.designpattern_android.domain.model.CoinsDetailsResponse
import fi.developer.designpattern_android.domain.model.CoinsResponseItem

interface NetworkRepository {
    suspend fun getCoins(): List<CoinsResponseItem>
    suspend fun getCoinById(coinId: String): CoinsDetailsResponse
}