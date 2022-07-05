package com.borisov.studentapplication.ui.classes

import androidx.lifecycle.MutableLiveData
import com.borisov.studentapplication.domain.AppState
import com.borisov.studentapplication.domain.models.Response
import com.borisov.studentapplication.domain.usecases.GetLessonUseCase
import com.borisov.studentapplication.ui.base.BaseViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

/**
 * @author Borisov Andrey on 04.07.2022
 **/
class ClassesViewModel(
    private val lessonsLiveData: MutableLiveData<AppState<Response>>
    = MutableLiveData<AppState<Response>>(),
    private val getLessonUseCase: GetLessonUseCase,
) : BaseViewModel() {

    fun getLessonsLiveData() = lessonsLiveData

    fun getLessons(): Job =
        viewModelScopeCoroutine.launch {
            getLessonsLiveData().postValue(
                getLessonUseCase.execute()
            )
        }

    override fun handleError(throwable: Throwable) {}
}