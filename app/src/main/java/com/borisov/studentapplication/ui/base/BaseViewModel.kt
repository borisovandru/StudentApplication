package com.borisov.studentapplication.ui.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

/**
 * @author Borisov Andrey on 04.07.2022
 **/
abstract class BaseViewModel : ViewModel() {
    protected val viewModelScopeCoroutine = CoroutineScope(
        Dispatchers.IO
                + SupervisorJob()
                + CoroutineExceptionHandler { _, throwable ->
            handleError(throwable)
        }
    )

    abstract fun handleError(throwable: Throwable)

    override fun onCleared() {
        super.onCleared()
        viewModelScopeCoroutine
            .coroutineContext
            .cancel()
    }
}