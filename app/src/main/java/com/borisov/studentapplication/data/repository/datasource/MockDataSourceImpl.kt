package com.borisov.studentapplication.data.repository.datasource

import com.borisov.studentapplication.data.mockGetExam
import com.borisov.studentapplication.data.mockGetHomWork
import com.borisov.studentapplication.data.mockGetLessons
import com.borisov.studentapplication.data.models.FacultativeResponse
import com.borisov.studentapplication.data.models.LessonResponse
import com.borisov.studentapplication.data.tags
import com.borisov.studentapplication.domain.AppState
import com.borisov.studentapplication.domain.models.*

/**
 * @author Borisov Andrey on 04.07.2022
 **/
class MockDataSourceImpl : DataSource {
    override suspend fun getLessons(): AppState<Lessons> {
        val result = mockGetLessons()
        return AppState.Success<Lessons>(Lessons(
            data = result.map {
                when (it) {
                    is FacultativeResponse -> {
                        Facultative(
                            id = it.id,
                            title = it.title,
                            icon = it.icon,
                            scheduler = it.scheduler,
                            teacher = it.teacher,
                            tagIconOne = it.tagIconOne,
                            tagIconTwo = it.tagIconTwo,
                            tagIconThree = it.tagIconThree,
                            description = it.description,
                            isTop = it.isTop
                        )
                    }
                    is LessonResponse -> {
                        Lesson(
                            id = it.id,
                            title = it.title,
                            icon = it.icon,
                            scheduler = it.scheduler,
                            useRemote = it.useRemote,
                            teacher = it.teacher,
                            isTop = it.isTop
                        )
                    }
                    else -> {
                        throw Exception("Unknown type")
                    }
                }
            }
        ))
    }

    override suspend fun getHomeWork(): AppState<HomeWorks> {
        val result = mockGetHomWork()
        return AppState.Success<HomeWorks>(HomeWorks(
            data = result.map {
                HomeWork(
                    id = it.id,
                    title = it.title,
                    icon = it.icon,
                    deadLine = it.deadLine,
                    work = it.work,
                    tagIconOne = tags.first(),
                    tagIconTwo = tags.last()
                )
            }
        ))
    }

    override suspend fun getExamDate(): AppState<Exam> {
        val result = mockGetExam()
        return AppState.Success<Exam>(
            Exam(
                date = result.date
            )
        )
    }
}