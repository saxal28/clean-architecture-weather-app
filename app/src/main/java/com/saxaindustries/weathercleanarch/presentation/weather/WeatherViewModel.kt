package com.saxaindustries.weathercleanarch.presentation.weather

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.saxaindustries.weathercleanarch.common.Result
import com.saxaindustries.weathercleanarch.domain.usecase.FetchWeatherByZipCodeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val fetchWeatherByZipCodeUseCase: FetchWeatherByZipCodeUseCase
) : ViewModel() {

    private var _state = mutableStateOf(WeatherState())
    private val state: State<WeatherState> get() = _state

    init {
        getWeather()
    }

    private fun getWeather(){
        fetchWeatherByZipCodeUseCase(62229).onEach { result ->
            when(result) {
                is Result.Success -> {
                    _state.value = WeatherState(data = result.data)
                }
                is Result.Loading -> {
                    _state.value = WeatherState(isLoading = true)
                }
                is Result.Error -> {
                    _state.value = WeatherState(error = result.errorMessage ?: "Something is Wrong")
                }
            }
        }.launchIn(viewModelScope)
    }
}