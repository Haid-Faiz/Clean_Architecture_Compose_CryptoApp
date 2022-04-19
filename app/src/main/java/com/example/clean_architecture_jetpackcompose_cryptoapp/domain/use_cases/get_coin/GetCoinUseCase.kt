package com.example.clean_architecture_jetpackcompose_cryptoapp.domain.use_cases.get_coin

import com.example.clean_architecture_jetpackcompose_cryptoapp.common.Resource
import com.example.clean_architecture_jetpackcompose_cryptoapp.domain.repositories.CoinRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val coinRepository: CoinRepository
) {

    operator fun invoke(coinId: String) = flow {
        emit(Resource.Loading())
        emit(coinRepository.getCoinById(coinId = coinId))
    }
}