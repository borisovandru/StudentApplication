package com.borisov.studentapplication.domain.models

/**
 * @author Borisov Andrey on 04.07.2022
 **/
data class Lessons(
    val data: List<Lessonable>
) : Response