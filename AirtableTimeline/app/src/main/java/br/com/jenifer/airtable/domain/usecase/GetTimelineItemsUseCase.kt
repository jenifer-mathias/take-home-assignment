package br.com.jenifer.airtable.domain.usecase

import br.com.jenifer.airtable.data.model.Event
import br.com.jenifer.airtable.data.repository.EventDataRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetTimelineItemsUseCase @Inject constructor(
    private val repository: EventDataRepository
) {
    fun execute(): Flow<List<List<Event>>> {
        return repository.getTimelineItems()
            .map { events ->
                arrangeEventsInLanes(events)
            }
    }

    private fun arrangeEventsInLanes(events: List<Event>): List<List<Event>> {
        val lanes = mutableListOf<MutableList<Event>>()

        events.sortedBy { it.startDate.timeInMillis }
            .forEach { event ->
                val lane = lanes.firstOrNull { lane ->
                    lane.last().endDate.before(event.startDate)
                }
                if (lane != null) {
                    lane.add(event)
                } else {
                    lanes.add(mutableListOf(event))
                }
            }

        return lanes
    }
}
