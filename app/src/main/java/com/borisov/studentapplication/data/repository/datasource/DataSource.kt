package com.borisov.studentapplication.data.repository.datasource

import com.borisov.studentapplication.domain.AppState
import com.borisov.studentapplication.domain.models.Exam
import com.borisov.studentapplication.domain.models.HomeWorks
import com.borisov.studentapplication.domain.models.Lessons

/**
 * @author Borisov Andrey on 04.07.2022
 **/
interface DataSource {
    suspend fun getLessons(): AppState<Lessons>
    suspend fun getHomeWork(): AppState<HomeWorks>
    suspend fun getExamDate(): AppState<Exam>
}