package com.example.clean_architecture_jetpackcompose_cryptoapp.data.remote.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TeamMember(
    @SerialName("id")
    var id: String,
    @SerialName("name")
    var name: String,
    @SerialName("position")
    var position: String
)