package com.example.clean_architecture_jetpackcompose_cryptoapp.domain.models

import com.example.clean_architecture_jetpackcompose_cryptoapp.data.remote.dto.Team

data class CoinDetail(
    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<Team>
)
