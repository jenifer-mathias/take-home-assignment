package br.com.jenifer.airtable.ui.timeline

import br.com.jenifer.airtable.data.model.Event

data class TimelineUiState(
    val lanes: List<List<Event>> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
    val scale: Float = 1f
)