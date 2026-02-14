package fi.developer.designpattern_android.presentation.viewmodel.coin_list

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fi.developer.designpattern_android.core.Resource
import fi.developer.designpattern_android.domain.use_case.GetCoinsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel(){
    private val _state = MutableStateFlow(CoinListState())
    val state: StateFlow<CoinListState> = _state.asStateFlow()


    init {
        Log.d("Coins", "init")
        getCoins()
    }

    private fun getCoins() {
        getCoinsUseCase().onEach { result ->
            Log.d("Coins", "result: $result")
            when (result) {
                is Resource.Success->{
                    Log.d("Coins", "result.data: ${result.data}")
                    _state.value = CoinListState(coins = result.data ?: emptyList())
                }
                is Resource.Error->{
                    _state.value = CoinListState(error = result.message ?: "An unexpected error occured")
                }
                is Resource.Loading->{
                    _state.value = CoinListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}