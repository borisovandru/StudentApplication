package com.borisov.studentapplication.domain.models

/**
 * @author Borisov Andrey on 04.07.2022
 **/
data class Facultative(
    val id: Int,
    val title: String,
    val icon: Int,
    val scheduler: Schedulers,
    val teacher: String,
    val tagIconOne: Int,
    val tagIconTwo: Int,
    val tagIconThree: Int,
    val description: String,
    val isTop: Boolean = false
) : Lessonable