package com.borisov.studentapplication.domain.usecases

import com.borisov.studentapplication.domain.AppState
import com.borisov.studentapplication.domain.models.Exam
import com.borisov.studentapplication.domain.repository.Repository

/**
 * @author Borisov Andrey on 04.07.2022
 **/
class GetExamUseCase(private val repository: Repository) {
    suspend fun execute(): AppState<Exam> =
        repository.getExamDate()
}