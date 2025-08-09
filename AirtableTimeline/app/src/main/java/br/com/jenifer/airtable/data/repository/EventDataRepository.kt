package br.com.jenifer.airtable.data.repository

import br.com.jenifer.airtable.data.model.Event
import kotlinx.coroutines.flow.Flow

interface EventDataRepository {
    fun getTimelineItems(): Flow<List<Event>>
}