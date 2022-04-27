package com.example.clean_architecture_jetpackcompose_cryptoapp.presentation

sealed class Screen(val route: String) {
    object CoinListScreen : Screen(route = "coin_list_screen")
    object CoinDetailScreen : Screen(route = "coin_detail_screen")
}
