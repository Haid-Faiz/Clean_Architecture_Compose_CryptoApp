package com.example.clean_architecture_jetpackcompose_cryptoapp.presentation.coin_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clean_architecture_jetpackcompose_cryptoapp.common.Constants.NAV_PARAM_COIN_ID
import com.example.clean_architecture_jetpackcompose_cryptoapp.common.Resource
import com.example.clean_architecture_jetpackcompose_cryptoapp.domain.models.CoinDetail
import com.example.clean_architecture_jetpackcompose_cryptoapp.domain.use_cases.get_coin.GetCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailsViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(CoinDetailState())
    val state: State<CoinDetailState> = _state

    init {
        savedStateHandle.get<String>(NAV_PARAM_COIN_ID)?.let { coinId ->
            getCoinDetail(coinId = coinId)
        }
    }

    private fun getCoinDetail(coinId: String) = getCoinUseCase(coinId = coinId)
        .onEach { response: Resource<CoinDetail> ->
            when (response) {

                is Resource.Success -> {
                    _state.value = CoinDetailState(coin = response.data)
                }
                is Resource.Error -> {
                    _state.value = CoinDetailState(
                        error = response.message ?: "Something went wrong"
                    )
                }
                is Resource.Loading -> {
                    _state.value = CoinDetailState(isLoading = true)
                }
            }
        }.catch {
            _state.value = CoinDetailState(error = it.message ?: "Something went wrong")
        }.launchIn(viewModelScope)

}