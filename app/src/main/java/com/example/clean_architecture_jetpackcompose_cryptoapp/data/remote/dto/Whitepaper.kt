package com.example.clean_architecture_jetpackcompose_cryptoapp.data.remote.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Whitepaper(
    @SerialName("link")
    var link: String? = null,
    @SerialName("thumbnail")
    var thumbnail: String? = null
)