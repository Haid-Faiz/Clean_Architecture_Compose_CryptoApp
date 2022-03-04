package com.example.clean_architecture_jetpackcompose_cryptoapp.data.remote.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LinksExtended(
    @SerialName("stats")
    var stats: Stats? = null,
    @SerialName("type")
    var type: String? = null,
    @SerialName("url")
    var url: String? = null
)