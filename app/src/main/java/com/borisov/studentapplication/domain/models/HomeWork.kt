package com.borisov.studentapplication.domain.models

/**
 * @author Borisov Andrey on 04.07.2022
 **/
data class HomeWork(
    val id: Int,
    val title: String,
    val icon: Int,
    val deadLine: String,
    val work: String,
    val tagIconOne: Int,
    val tagIconTwo: Int
)