package br.com.jenifer.airtable.data.model

import br.com.jenifer.airtable.createCalendar

object SampleTimelineItems {
    private val year = 2020 - 1900
    var timelineItems: List<Event> = listOf(
        Event(
            1,
            createCalendar(year, 1, 1),
            createCalendar(year, 1, 5),
            "First item"
        ),
        Event(
            2,
            createCalendar(year, 1, 2),
            createCalendar(year, 1, 8),
            "Second item"
        ),
        Event(
            3,
            createCalendar(year, 1, 6),
            createCalendar(year, 1, 13),
            "Another item"
        ),
        Event(
            4,
            createCalendar(year, 1, 14),
            createCalendar(year, 1, 14),
            "Another item"
        ),
        Event(
            5,
            createCalendar(year, 2, 1),
            createCalendar(year, 2, 15),
            "Third item"
        ),
        Event(
            6,
            createCalendar(year, 1, 12),
            createCalendar(year, 2, 16),
            "Fourth item with a super long name"
        ),
        Event(
            7,
            createCalendar(year, 2, 1),
            createCalendar(year, 2, 2),
            "Fifth item with a super long name"
        ),
        Event(
            8,
            createCalendar(year, 1, 3),
            createCalendar(year, 1, 5),
            "First item"
        ),
        Event(
            9,
            createCalendar(year, 1, 4),
            createCalendar(year, 1, 8),
            "Second item"
        ),
        Event(
            10,
            createCalendar(year, 1, 6),
            createCalendar(year, 1, 13),
            "Another item"
        ),
        Event(
            11,
            createCalendar(year, 1, 9),
            createCalendar(year, 1, 9),
            "Another item"
        ),
        Event(
            12,
            createCalendar(year, 2, 1),
            createCalendar(year, 2, 15),
            "Third item"
        ),
        Event(
            13,
            createCalendar(year, 1, 12),
            createCalendar(year, 2, 16),
            "Fourth item with a super long name"
        ),
        Event(
            14,
            createCalendar(year, 2, 1),
            createCalendar(year, 2, 1),
            "Fifth item with a super long name"
        )
    )
}