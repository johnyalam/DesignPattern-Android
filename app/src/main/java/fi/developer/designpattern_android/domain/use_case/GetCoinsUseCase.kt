package fi.developer.designpattern_android.domain.use_case

import android.util.Log
import fi.developer.designpattern_android.core.Resource
import fi.developer.designpattern_android.domain.model.CoinsResponseItem
import fi.developer.designpattern_android.domain.repository.NetworkRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: NetworkRepository
){
    operator fun invoke(): Flow<Resource<List<CoinsResponseItem>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins()
            emit(Resource.Success(coins))
            Log.d("Coins", coins.toString())
        }catch(e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
            Log.e("Coins", e.localizedMessage)
        } catch(e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
            Log.e("Coins", e.localizedMessage)
        }
    }
}