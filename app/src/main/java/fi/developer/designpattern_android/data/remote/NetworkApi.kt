package fi.developer.designpattern_android.data.remote

import fi.developer.designpattern_android.domain.model.CoinsDetailsResponse
import fi.developer.designpattern_android.domain.model.CoinsResponseItem
import retrofit2.http.GET
import retrofit2.http.Path

interface NetworkApi {
    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinsResponseItem>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinsDetailsResponse
}