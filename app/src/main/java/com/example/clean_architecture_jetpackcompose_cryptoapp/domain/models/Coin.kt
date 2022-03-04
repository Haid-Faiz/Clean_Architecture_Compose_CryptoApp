package com.example.clean_architecture_jetpackcompose_cryptoapp.domain.models

data class Coin(
    val id: String,
    val isActive: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
)
