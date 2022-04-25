package com.example.clean_architecture_jetpackcompose_cryptoapp.presentation.coin_list

import com.example.clean_architecture_jetpackcompose_cryptoapp.domain.models.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
