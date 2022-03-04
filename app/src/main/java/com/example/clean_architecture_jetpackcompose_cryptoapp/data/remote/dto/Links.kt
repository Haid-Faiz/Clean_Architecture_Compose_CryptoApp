package com.example.clean_architecture_jetpackcompose_cryptoapp.data.remote.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Links(
    @SerialName("explorer")
    var explorer: List<String>? = null,
    @SerialName("facebook")
    var facebook: List<String>? = null,
    @SerialName("reddit")
    var reddit: List<String>? = null,
    @SerialName("source_code")
    var sourceCode: List<String>? = null,
    @SerialName("website")
    var website: List<String>? = null,
    @SerialName("youtube")
    var youtube: List<String>? = null
)