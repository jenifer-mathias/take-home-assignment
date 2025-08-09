package br.com.jenifer.airtable

import java.util.Calendar

fun createCalendar(
    year: Int,
    month: Int,
    day: Int,
    hour: Int = 0,
    minute: Int = 0,
    second: Int = 0
): Calendar {
    return Calendar.getInstance().apply {
        set(year, month - 1, day, hour, minute, second)
        set(Calendar.MILLISECOND, 0)
    }
}