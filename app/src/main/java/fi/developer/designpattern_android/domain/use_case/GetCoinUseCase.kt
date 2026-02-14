package fi.developer.designpattern_android.domain.use_case

import fi.developer.designpattern_android.core.Resource
import fi.developer.designpattern_android.domain.model.CoinsDetailsResponse
import fi.developer.designpattern_android.domain.repository.NetworkRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: NetworkRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinsDetailsResponse>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId)
            emit(Resource.Success(coin))
        } catch(e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}