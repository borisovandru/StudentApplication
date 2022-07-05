package com.borisov.studentapplication.domain.models

/**
 * @author Borisov Andrey on 04.07.2022
 **/
data class ExamTime(
    val dayFirst: String,
    val daySecond: String,
    val hourFirst: String,
    val hourSecond: String,
    val minuteFirst: String,
    val minuteSecond: String
) : Response