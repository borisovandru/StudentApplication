package com.borisov.studentapplication.domain.repository

import com.borisov.studentapplication.domain.AppState
import com.borisov.studentapplication.domain.models.Exam
import com.borisov.studentapplication.domain.models.HomeWorks
import com.borisov.studentapplication.domain.models.Lessons

/**
 * @author Borisov Andrey on 04.07.2022
 **/
interface Repository {
    suspend fun getLessons(): AppState<Lessons>
    suspend fun getHomeWork(): AppState<HomeWorks>
    suspend fun getExamDate(): AppState<Exam>
}