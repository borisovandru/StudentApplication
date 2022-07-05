package com.borisov.studentapplication.utils

import com.borisov.studentapplication.domain.models.ExamTime
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.math.abs

/**
 * @author Borisov Andrey on 04.07.2022
 **/
fun upperMonthInString(target: String): String? {
    return try {
        var result: String = ""
        target.split(" ").forEach {
            result += it.replaceFirstChar(Char::titlecase) + " "
        }
        result
    } catch (err: Exception) {
        null
    }
}

fun dateBetween(dateExam: String): ExamTime? {
    val sdf = SimpleDateFormat("yyyy.MM.dd HH:mm", Locale.getDefault())
    val firstDate: Date = Date(System.currentTimeMillis())
    val secondDate: Date? = sdf.parse(dateExam)

    secondDate?.let {
        val diffInMillies: Long = abs(it.time - firstDate.time)
        val diffMinutes: Long = TimeUnit.MINUTES.convert(diffInMillies, TimeUnit.MILLISECONDS)

        val days = String.format("%02d", diffMinutes / 60 / 24)
        val hours = String.format("%02d", diffMinutes / 60 - ((diffMinutes / 60 / 24) * 24))
        val minutes = String.format("%02d", diffMinutes % 60)

        return ExamTime(
            dayFirst = days.substring(0, 1),
            daySecond = days.substring(1, 2),
            hourFirst = hours.substring(0, 1),
            hourSecond = hours.substring(1, 2),
            minuteFirst = minutes.substring(0, 1),
            minuteSecond = minutes.substring(1, 2)
        )
    }
    return null
}

fun getCurrentDate(): String =
    SimpleDateFormat(DATE_PATTERN_TEMPLATE, Locale.getDefault())
        .format(Date(System.currentTimeMillis()))

fun dayLeftFrom(date: String): Long {
    val sdf = SimpleDateFormat(FULL_DATE_PATTERN_TEMPLATE, Locale.getDefault())
    val firstDate: Date = Date(System.currentTimeMillis())
    sdf.parse(date)?.let {
        val diffInMillis: Long = abs(it.time - firstDate.time)
        return TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS)
    }
    return 0
}

const val DATE_PATTERN_TEMPLATE = "dd MMMM"
const val FULL_DATE_PATTERN_TEMPLATE = "yyyy.MM.dd"
