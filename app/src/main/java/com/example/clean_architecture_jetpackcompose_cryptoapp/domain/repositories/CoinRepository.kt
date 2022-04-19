package com.example.clean_architecture_jetpackcompose_cryptoapp.domain.repositories

import com.example.clean_architecture_jetpackcompose_cryptoapp.common.Resource
import com.example.clean_architecture_jetpackcompose_cryptoapp.domain.models.Coin
import com.example.clean_architecture_jetpackcompose_cryptoapp.domain.models.CoinDetail

interface CoinRepository {

    suspend fun getCoins() : Resource<List<Coin>>

    suspend fun getCoinById(coinId: String) : Resource<CoinDetail>
}