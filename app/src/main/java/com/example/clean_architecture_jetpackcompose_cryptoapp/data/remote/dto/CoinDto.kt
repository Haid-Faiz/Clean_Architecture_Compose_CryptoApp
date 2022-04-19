package com.example.clean_architecture_jetpackcompose_cryptoapp.data.remote.dto

import com.example.clean_architecture_jetpackcompose_cryptoapp.domain.models.Coin
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinDto(
    @SerialName("id")
    var id: String,
    @SerialName("is_active")
    var isActive: Boolean,
    @SerialName("is_new")
    var isNew: Boolean,
    @SerialName("name")
    var name: String,
    @SerialName("rank")
    var rank: Int,
    @SerialName("symbol")
    var symbol: String,
    @SerialName("type")
    var type: String
)

fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id,
        isActive = isActive,
        name = name,
        rank = rank,
        symbol = symbol
    )
}