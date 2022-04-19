package com.example.clean_architecture_jetpackcompose_cryptoapp.data.remote.dto


import com.example.clean_architecture_jetpackcompose_cryptoapp.domain.models.CoinDetail
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinDetailDto(
    @SerialName("description")
    var description: String,
    @SerialName("development_status")
    var developmentStatus: String,
    @SerialName("first_data_at")
    var firstDataAt: String,
    @SerialName("hardware_wallet")
    var hardwareWallet: Boolean,
    @SerialName("hash_algorithm")
    var hashAlgorithm: String,
    @SerialName("id")
    var id: String,
    @SerialName("is_active")
    var isActive: Boolean,
    @SerialName("is_new")
    var isNew: Boolean,
    @SerialName("last_data_at")
    var lastDataAt: String,
    @SerialName("links")
    var links: Links,
    @SerialName("links_extended")
    var linksExtended: List<LinksExtended>,
    @SerialName("message")
    var message: String,
    @SerialName("name")
    var name: String,
    @SerialName("open_source")
    var openSource: Boolean,
    @SerialName("org_structure")
    var orgStructure: String,
    @SerialName("proof_type")
    var proofType: String,
    @SerialName("rank")
    var rank: Int,
    @SerialName("started_at")
    var startedAt: String,
    @SerialName("symbol")
    var symbol: String,
    @SerialName("tags")
    var tags: List<Tag>,
    @SerialName("team")
    var team: List<TeamMember>,
    @SerialName("type")
    var type: String,
    @SerialName("whitepaper")
    var whitepaper: Whitepaper
)

fun CoinDetailDto.toCoinDetail(): CoinDetail {
    return CoinDetail(
        coinId = id,
        name = name,
        description = description,
        symbol = symbol,
        rank = rank,
        isActive = isActive,
        tags = tags.map { it.name },
        team = team
    )
}