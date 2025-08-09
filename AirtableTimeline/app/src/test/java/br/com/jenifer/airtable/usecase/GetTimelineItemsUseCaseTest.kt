package br.com.jenifer.airtable.usecase

import br.com.jenifer.airtable.data.model.SampleTimelineItems
import br.com.jenifer.airtable.data.repository.EventDataRepository
import br.com.jenifer.airtable.domain.usecase.GetTimelineItemsUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class GetTimelineItemsUseCaseTest {

    private lateinit var repository: EventDataRepository
    private lateinit var useCase: GetTimelineItemsUseCase

    @Before
    fun setup() {
        repository = mockk()
        useCase = GetTimelineItemsUseCase(repository)
    }

    @Test
    fun `execute returns events arranged in lanes`() = runBlocking {
        val events = listOf(
            SampleTimelineItems.timelineItems[0],
            SampleTimelineItems.timelineItems[1]
        )
        coEvery { repository.getTimelineItems() } returns flowOf(events)

        val lanes = useCase.execute().first()

        assertTrue(lanes.isNotEmpty())
        assertTrue(lanes.all { it.isNotEmpty() })
    }
}

