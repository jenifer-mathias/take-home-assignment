package br.com.jenifer.airtable.ui.timeline

sealed interface TimelineIntent {
    object LoadTimeline : TimelineIntent
    data class Zoom(val scale: Float) : TimelineIntent
}