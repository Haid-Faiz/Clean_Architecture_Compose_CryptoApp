package com.example.clean_architecture_jetpackcompose_cryptoapp.data.repositories

import com.example.clean_architecture_jetpackcompose_cryptoapp.common.Resource
import com.example.clean_architecture_jetpackcompose_cryptoapp.data.remote.CoinPaprikaApi
import com.example.clean_architecture_jetpackcompose_cryptoapp.data.remote.dto.toCoin
import com.example.clean_architecture_jetpackcompose_cryptoapp.data.remote.dto.toCoinDetail
import com.example.clean_architecture_jetpackcompose_cryptoapp.domain.models.Coin
import com.example.clean_architecture_jetpackcompose_cryptoapp.domain.models.CoinDetail
import com.example.clean_architecture_jetpackcompose_cryptoapp.domain.repositories.CoinRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {

    override suspend fun getCoins(): Resource<List<Coin>> = try {

        val coins = api.getCoins()
        Resource.Success(data = coins.map { it.toCoin() })

    } catch (e: HttpException) {
        Resource.Error(message = e.localizedMessage ?: "Something went wrong!")
    } catch (e: IOException) {
        Resource.Error(message = "Couldn't reach server! Please check your internet connection")
    }


    override suspend fun getCoinById(coinId: String): Resource<CoinDetail> = try {

        val coin = api.getCoinById(coinId = coinId)
        Resource.Success<CoinDetail>(data = coin.toCoinDetail())

    } catch (e: HttpException) {
        Resource.Error<CoinDetail>(message = e.localizedMessage ?: "Something went wrong!")
    } catch (e: IOException) {
        Resource.Error<CoinDetail>(message = "Couldn't reach server! Please check your internet connection")
    }

}