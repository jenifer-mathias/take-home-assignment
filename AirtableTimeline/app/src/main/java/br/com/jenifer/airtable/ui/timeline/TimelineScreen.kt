package br.com.jenifer.airtable.ui.timeline

import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import br.com.jenifer.airtable.data.model.Event
import br.com.jenifer.airtable.ui.theme.DarkBlue
import br.com.jenifer.airtable.ui.theme.CardContainerGreen
import br.com.jenifer.airtable.ui.theme.CardContainerLightBlue
import br.com.jenifer.airtable.ui.theme.CardContainerOrange
import br.com.jenifer.airtable.ui.theme.CardContainerPurple
import br.com.jenifer.airtable.ui.theme.CardContainerRed
import br.com.jenifer.airtable.ui.theme.CardContainerTeal
import br.com.jenifer.airtable.ui.theme.CardContainerYellow
import java.util.Calendar

@Composable
fun TimelineScreen(viewModel: TimelineViewModel = hiltViewModel()) {
    val uiState by viewModel.uiState.collectAsState()

    when {
        uiState.isLoading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        uiState.error != null -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = uiState.error ?: "Erro desconhecido",
                    color = Color.Red
                )
            }
        }

        else -> {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .pointerInput(Unit) {
                        detectTransformGestures { _, _, zoomChange, _ ->
                            val newScale = (uiState.scale * zoomChange).coerceIn(0.5f, 3f)
                            viewModel.onEvent(TimelineIntent.Zoom(newScale))
                        }
                    }
                    .graphicsLayer(
                        scaleX = uiState.scale,
                        scaleY = uiState.scale
                    )
            ) {
                TimelineContent(uiState.lanes)
            }
        }
    }
}

@Composable
fun TimelineContent(lanes: List<List<Event>>) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(lanes) { lane ->
            Lane(events = lane)
        }
    }
}

@Composable
fun Lane(events: List<Event>) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
    ) {
        items(events) { event ->
            val durationDays = daysBetween(event.startDate, event.endDate)
            val calculatedWidth = 40.dp * durationDays

            val cardContainerColors = listOf(
                CardContainerGreen,
                CardContainerTeal,
                CardContainerOrange,
                CardContainerRed,
                CardContainerPurple,
                DarkBlue,
                CardContainerLightBlue,
                CardContainerYellow
            )


            val randomContainerCardColor = remember {
                cardContainerColors.random()
            }

            Card(
                colors = CardColors(
                    containerColor = randomContainerCardColor,
                    contentColor = Color.White,
                    disabledContentColor = Color.Gray,
                    disabledContainerColor = Color.DarkGray
                ),
                shape = RoundedCornerShape(2.dp),
                modifier = Modifier
                    .widthIn(min = 100.dp)
                    .width(calculatedWidth)
                    .height(80.dp),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Column(Modifier.padding(8.dp)) {
                    Text(
                        text = event.name,
                        style = MaterialTheme.typography.bodyLarge,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(text = "$durationDays dias", style = MaterialTheme.typography.bodySmall)
                }
            }
        }
    }
}

fun daysBetween(start: Calendar, end: Calendar): Int {
    val diff = end.timeInMillis - start.timeInMillis
    return (diff / (24 * 60 * 60 * 1000)).toInt() + 1
}