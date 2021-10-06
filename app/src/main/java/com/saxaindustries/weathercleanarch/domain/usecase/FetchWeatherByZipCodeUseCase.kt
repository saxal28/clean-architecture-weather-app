package com.saxaindustries.weathercleanarch.domain.usecase

import com.saxaindustries.weathercleanarch.common.Result
import com.saxaindustries.weathercleanarch.data.api.dto.toModel
import com.saxaindustries.weathercleanarch.domain.model.Weather
import com.saxaindustries.weathercleanarch.domain.repository.WeatherRepository
import java.lang.Exception
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FetchWeatherByZipCodeUseCase @Inject constructor(
    private val repository: WeatherRepository
) {
    operator fun invoke(zipCode: Int): Flow<Result<Weather>> = flow {
        try {
            emit(Result.Loading<Weather>())
            val result = repository.getWeather(zipCode).toModel
            emit(Result.Success(result))
        } catch (e: Exception) {
            emit(Result.Error<Weather>(e.localizedMessage ?: "Error Loading Zip Code"))
        }
    }
}