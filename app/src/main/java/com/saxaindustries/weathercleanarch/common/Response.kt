package com.saxaindustries.weathercleanarch.common

sealed class Result<T>(val data: T? = null, val errorMessage: String? = null) {
    class Success<T>(data: T) : Result<T>(data)
    class Error<T>(message: String, data: T? = null) : Result<T>(data, message)
    class Loading<T>(data: T? = null) : Result<T>(data)
}