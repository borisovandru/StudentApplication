package com.borisov.studentapplication.domain.models

/**
 * @author Borisov Andrey on 04.07.2022
 **/
data class Schedulers(
    val start: String,
    val end: String
) {
    override fun toString(): String = "$start - $end"
}