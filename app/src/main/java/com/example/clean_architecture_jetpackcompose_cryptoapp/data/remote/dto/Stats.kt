package com.example.clean_architecture_jetpackcompose_cryptoapp.data.remote.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Stats(
    @SerialName("contributors")
    var contributors: Int? = null,
    @SerialName("followers")
    var followers: Int? = null,
    @SerialName("stars")
    var stars: Int? = null,
    @SerialName("subscribers")
    var subscribers: Int? = null
)