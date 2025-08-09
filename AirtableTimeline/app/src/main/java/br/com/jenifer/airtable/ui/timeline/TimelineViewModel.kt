package br.com.jenifer.airtable.ui.timeline

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.jenifer.airtable.domain.usecase.GetTimelineItemsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TimelineViewModel @Inject constructor(
    private val getTimelineItemsUseCase: GetTimelineItemsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(TimelineUiState())
    val uiState: StateFlow<TimelineUiState> = _uiState.asStateFlow()

    init {
        onEvent(TimelineIntent.LoadTimeline)
    }

    fun onEvent(intent: TimelineIntent) {
        when (intent) {
            is TimelineIntent.LoadTimeline -> loadTimeline()
            is TimelineIntent.Zoom -> updateZoom(intent.scale)
        }
    }

    private fun loadTimeline() {
        viewModelScope.launch {
            getTimelineItemsUseCase.execute()
                .onStart {
                    _uiState.update { it.copy(isLoading = true, error = null) }
                }
                .catch { e ->
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            error = e.message ?: "Erro desconhecido"
                        )
                    }
                }
                .collect { lanes ->
                    _uiState.update {
                        it.copy(
                            lanes = lanes,
                            isLoading = false,
                            error = null
                        )
                    }
                }
        }
    }

    private fun updateZoom(scale: Float) {
        _uiState.update { it.copy(scale = scale) }
    }
}
