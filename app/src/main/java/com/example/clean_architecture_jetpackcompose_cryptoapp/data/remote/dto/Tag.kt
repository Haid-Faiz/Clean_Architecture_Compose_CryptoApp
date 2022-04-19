package com.example.clean_architecture_jetpackcompose_cryptoapp.data.remote.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Tag(
    @SerialName("coin_counter")
    var coinCounter: Int,
    @SerialName("ico_counter")
    var icoCounter: Int,
    @SerialName("id")
    var id: String,
    @SerialName("name")
    var name: String
)