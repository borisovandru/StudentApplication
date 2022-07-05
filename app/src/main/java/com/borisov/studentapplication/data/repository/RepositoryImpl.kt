package com.borisov.studentapplication.data.repository

import com.borisov.studentapplication.data.repository.datasource.DataSource
import com.borisov.studentapplication.domain.AppState
import com.borisov.studentapplication.domain.models.Exam
import com.borisov.studentapplication.domain.models.HomeWorks
import com.borisov.studentapplication.domain.models.Lessons
import com.borisov.studentapplication.domain.repository.Repository

/**
 * @author Borisov Andrey on 04.07.2022
 **/
class RepositoryImpl(private val dataSource: DataSource) : Repository {
    override suspend fun getLessons(): AppState<Lessons> =
        dataSource.getLessons()

    override suspend fun getHomeWork(): AppState<HomeWorks> =
        dataSource.getHomeWork()

    override suspend fun getExamDate(): AppState<Exam> =
        dataSource.getExamDate()
}