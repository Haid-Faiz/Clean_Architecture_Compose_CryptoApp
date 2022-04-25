package com.example.clean_architecture_jetpackcompose_cryptoapp.di

import com.example.clean_architecture_jetpackcompose_cryptoapp.common.Constants
import com.example.clean_architecture_jetpackcompose_cryptoapp.data.remote.CoinPaprikaApi
import com.example.clean_architecture_jetpackcompose_cryptoapp.data.repositories.CoinRepositoryImpl
import com.example.clean_architecture_jetpackcompose_cryptoapp.domain.repositories.CoinRepository
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCoinPaprikaApi(): CoinPaprikaApi {
        // Creating kotlinx serialization converter factory for Retrofit
        val contentType = "application/json".toMediaType()
        val kotlinxConverterFactory = Json.asConverterFactory(contentType)

        return Retrofit
            .Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(kotlinxConverterFactory)
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaApi): CoinRepository {
        return CoinRepositoryImpl(api = api)
    }

}