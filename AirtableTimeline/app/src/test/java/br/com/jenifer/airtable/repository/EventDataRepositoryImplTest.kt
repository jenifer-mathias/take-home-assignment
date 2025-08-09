package br.com.jenifer.airtable.repository

import br.com.jenifer.airtable.data.model.SampleTimelineItems
import br.com.jenifer.airtable.data.repository.EventDataRepositoryImpl
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class EventDataRepositoryImplTest {

    private val repository = EventDataRepositoryImpl()

    @Test
    fun `getTimelineItems returns sample timeline items`() = runBlocking {
        val events = repository.getTimelineItems().first()
        assertEquals(SampleTimelineItems.timelineItems, events)
    }
}
