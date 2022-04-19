package com.example.clean_architecture_jetpackcompose_cryptoapp.domain.use_cases.get_coins

import com.example.clean_architecture_jetpackcompose_cryptoapp.common.Resource
import com.example.clean_architecture_jetpackcompose_cryptoapp.domain.repositories.CoinRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val coinRepository: CoinRepository
) {

    operator fun invoke() = flow {
        emit(Resource.Loading())
        emit(coinRepository.getCoins())
    }
}