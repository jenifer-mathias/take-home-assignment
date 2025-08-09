package br.com.jenifer.airtable.data.model

import java.util.Calendar

data class Event(
    val id: Int,
    val startDate: Calendar,
    val endDate: Calendar,
    val name: String
)