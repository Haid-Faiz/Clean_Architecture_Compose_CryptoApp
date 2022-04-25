package com.example.clean_architecture_jetpackcompose_cryptoapp.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clean_architecture_jetpackcompose_cryptoapp.common.Resource
import com.example.clean_architecture_jetpackcompose_cryptoapp.domain.models.Coin
import com.example.clean_architecture_jetpackcompose_cryptoapp.domain.use_cases.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(CoinListState())
    val state: State<CoinListState> = _state

    init {
        getCoins()
    }

    private fun getCoins() = getCoinsUseCase().onEach { response: Resource<List<Coin>> ->
        when (response) {

            is Resource.Success -> {
                _state.value = CoinListState(coins = response.data ?: emptyList())
            }
            is Resource.Error -> {
                _state.value = CoinListState(error = response.message ?: "Something went wrong")
            }
            is Resource.Loading -> {
                _state.value = CoinListState(isLoading = true)
            }
        }
    }.catch {
        _state.value = CoinListState(error = it.message ?: "Something went wrong")
    }.launchIn(viewModelScope)

}