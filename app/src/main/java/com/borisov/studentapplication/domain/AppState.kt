package com.borisov.studentapplication.domain

/**
 * @author Borisov Andrey on 04.07.2022
 **/
sealed class AppState<out T> : IAppState {
    data class Success<out T>(val data: T) : AppState<T>()
    data class Error(val error: Throwable) : AppState<Nothing>()
    object Loading : AppState<Nothing>()
}
