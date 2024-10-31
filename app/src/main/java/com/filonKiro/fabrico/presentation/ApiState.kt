package com.filonKiro.fabrico.presentation

sealed class ApiState<out T> {
    data class Success<T>(val data: T?) : ApiState<T>()
    data class Error<T>(val error: String) : ApiState<T>()
    data object Loading : ApiState<Nothing>()
}