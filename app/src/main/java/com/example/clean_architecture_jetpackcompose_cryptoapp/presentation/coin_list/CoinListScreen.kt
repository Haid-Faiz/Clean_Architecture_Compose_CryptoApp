package com.example.clean_architecture_jetpackcompose_cryptoapp.presentation.coin_list

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.clean_architecture_jetpackcompose_cryptoapp.domain.models.Coin
import com.example.clean_architecture_jetpackcompose_cryptoapp.presentation.Screen
import com.example.clean_architecture_jetpackcompose_cryptoapp.presentation.coin_list.components.CoinListItem

@Composable
fun CoinListScreen(
    navController: NavController,
    viewModel: CoinListViewModel = hiltViewModel<CoinListViewModel>()
) {

    // it would be either loading, error, success
    val state = viewModel.state.value

    Box(modifier = Modifier.fillMaxSize()) {

        // It's a recyclerview in compose
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            // item()
            items(state.coins) { coin: Coin ->
                CoinListItem(
                    coin = coin,
                    onItemClick = { navController.navigate(Screen.CoinDetailScreen.route + "/${coin.id}") }
                )
            }
        }

        if (state.error.isNotEmpty()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            )
            Toast.makeText(LocalContext.current, state.error, Toast.LENGTH_SHORT).show()
        }

        if (state.isLoading) {
            CircularProgressIndicator()
        }
    }

}