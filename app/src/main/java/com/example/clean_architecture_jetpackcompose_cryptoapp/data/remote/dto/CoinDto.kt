package com.example.clean_architecture_jetpackcompose_cryptoapp.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinDto(
    @SerialName("id")
    var id: String? = null,
    @SerialName("is_active")
    var isActive: Boolean? = null,
    @SerialName("is_new")
    var isNew: Boolean? = null,
    @SerialName("name")
    var name: String? = null,
    @SerialName("rank")
    var rank: Int? = null,
    @SerialName("symbol")
    var symbol: String? = null,
    @SerialName("type")
    var type: String? = null
)