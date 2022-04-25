package com.example.clean_architecture_jetpackcompose_cryptoapp.presentation.coin_details

import com.example.clean_architecture_jetpackcompose_cryptoapp.domain.models.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
