package com.example.clean_architecture_jetpackcompose_cryptoapp.presentation.coin_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.clean_architecture_jetpackcompose_cryptoapp.domain.models.Coin

@Composable
fun CoinListItem(
    coin: Coin,
    onItemClick: (coinId: String) -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable { onItemClick(coin.id) }
            .padding(18.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            text = "${coin.rank}.)  ${coin.name} (${coin.symbol})",
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.align(Alignment.CenterVertically)
        )

        Text(
            text = if (coin.isActive) "active" else "inactive",
            color = if (coin.isActive) Color.Green else Color.Red,
            fontStyle = FontStyle.Italic,
            style = MaterialTheme.typography.body2,
            modifier = Modifier.align(Alignment.CenterVertically)
        )

    }
}