package br.com.jenifer.airtable.viewmodel

import br.com.jenifer.airtable.data.model.SampleTimelineItems
import br.com.jenifer.airtable.domain.usecase.GetTimelineItemsUseCase
import br.com.jenifer.airtable.ui.timeline.TimelineViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class TimelineViewModelTest {

    private lateinit var useCase: GetTimelineItemsUseCase
    private lateinit var viewModel: TimelineViewModel

    @Before
    fun setup() {
        useCase = mockk()
    }

    @Test
    fun `loadTimeline updates uiState with lanes`() = runBlocking {
        val lanes = listOf(
            SampleTimelineItems.timelineItems
        )
        coEvery { useCase.execute() } returns flowOf(lanes)

        viewModel = TimelineViewModel(useCase)

        val uiState = viewModel.uiState.value

        assertFalse(uiState.isLoading)
        assertEquals(lanes, uiState.lanes)
        assertNull(uiState.error)
    }
}
