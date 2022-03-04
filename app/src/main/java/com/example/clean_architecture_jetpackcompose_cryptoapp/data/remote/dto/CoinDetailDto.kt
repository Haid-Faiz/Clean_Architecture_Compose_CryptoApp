package com.example.clean_architecture_jetpackcompose_cryptoapp.data.remote.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinDetailDto(
    @SerialName("description")
    var description: String? = null,
    @SerialName("development_status")
    var developmentStatus: String? = null,
    @SerialName("first_data_at")
    var firstDataAt: String? = null,
    @SerialName("hardware_wallet")
    var hardwareWallet: Boolean? = null,
    @SerialName("hash_algorithm")
    var hashAlgorithm: String? = null,
    @SerialName("id")
    var id: String? = null,
    @SerialName("is_active")
    var isActive: Boolean? = null,
    @SerialName("is_new")
    var isNew: Boolean? = null,
    @SerialName("last_data_at")
    var lastDataAt: String? = null,
    @SerialName("links")
    var links: Links? = null,
    @SerialName("links_extended")
    var linksExtended: List<LinksExtended>? = null,
    @SerialName("message")
    var message: String? = null,
    @SerialName("name")
    var name: String? = null,
    @SerialName("open_source")
    var openSource: Boolean? = null,
    @SerialName("org_structure")
    var orgStructure: String? = null,
    @SerialName("proof_type")
    var proofType: String? = null,
    @SerialName("rank")
    var rank: Int? = null,
    @SerialName("started_at")
    var startedAt: String? = null,
    @SerialName("symbol")
    var symbol: String? = null,
    @SerialName("tags")
    var tags: List<Tag>? = null,
    @SerialName("team")
    var team: List<Team>? = null,
    @SerialName("type")
    var type: String? = null,
    @SerialName("whitepaper")
    var whitepaper: Whitepaper? = null
)