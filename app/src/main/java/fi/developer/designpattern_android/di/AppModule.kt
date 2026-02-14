package fi.developer.designpattern_android.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import fi.developer.designpattern_android.core.Constants
import fi.developer.designpattern_android.data.remote.NetworkApi
import fi.developer.designpattern_android.data.repository.CoinRepositoryImpl
import fi.developer.designpattern_android.domain.repository.NetworkRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import kotlin.jvm.java

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun networkApi(): NetworkApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NetworkApi::class.java)
    }


    @Provides
    @Singleton
    fun provideCoinRepository(api: NetworkApi): NetworkRepository {
        return CoinRepositoryImpl(api)
    }
}