package com.example.clean_architecture_jetpackcompose_cryptoapp.data.remote.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Tag(
    @SerialName("coin_counter")
    var coinCounter: Int? = null,
    @SerialName("ico_counter")
    var icoCounter: Int? = null,
    @SerialName("id")
    var id: String? = null,
    @SerialName("name")
    var name: String? = null
)