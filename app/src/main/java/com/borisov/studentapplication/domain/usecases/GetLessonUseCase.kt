package com.borisov.studentapplication.domain.usecases

import com.borisov.studentapplication.domain.AppState
import com.borisov.studentapplication.domain.models.Lessons
import com.borisov.studentapplication.domain.repository.Repository

/**
 * @author Borisov Andrey on 04.07.2022
 **/
class GetLessonUseCase(private val repository: Repository) {
    suspend fun execute(): AppState<Lessons> =
        repository.getLessons()
}