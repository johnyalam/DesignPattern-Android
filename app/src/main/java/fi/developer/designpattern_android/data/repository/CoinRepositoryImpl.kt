package fi.developer.designpattern_android.data.repository

import fi.developer.designpattern_android.data.remote.NetworkApi
import fi.developer.designpattern_android.domain.model.CoinsDetailsResponse
import fi.developer.designpattern_android.domain.model.CoinsResponseItem
import fi.developer.designpattern_android.domain.repository.NetworkRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: NetworkApi
) : NetworkRepository {

    override suspend fun getCoins(): List<CoinsResponseItem> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinsDetailsResponse {
        return api.getCoinById(coinId)
    }
}