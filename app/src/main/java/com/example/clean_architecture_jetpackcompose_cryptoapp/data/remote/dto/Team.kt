package com.example.clean_architecture_jetpackcompose_cryptoapp.data.remote.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Team(
    @SerialName("id")
    var id: String? = null,
    @SerialName("name")
    var name: String? = null,
    @SerialName("position")
    var position: String? = null
)