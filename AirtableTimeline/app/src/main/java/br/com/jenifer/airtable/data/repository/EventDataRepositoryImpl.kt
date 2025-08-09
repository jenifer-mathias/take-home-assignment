package br.com.jenifer.airtable.data.repository

import br.com.jenifer.airtable.data.model.Event
import br.com.jenifer.airtable.data.model.SampleTimelineItems
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EventDataRepositoryImpl @Inject constructor(): EventDataRepository {
    override fun getTimelineItems(): Flow<List<Event>> {
        return flowOf(SampleTimelineItems.timelineItems)
    }
}