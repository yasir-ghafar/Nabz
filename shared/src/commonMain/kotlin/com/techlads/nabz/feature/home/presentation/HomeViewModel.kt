package com.techlads.nabz.feature.home.presentation

import androidx.lifecycle.ViewModel
import com.techlads.nabz.feature.home.domain.Greeting
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HomeViewModel(
    private val greeting: Greeting = Greeting(),
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    fun onToggleContent() {
        _uiState.update { state ->
            val showContent = !state.showContent
            state.copy(
                showContent = showContent,
                greeting = if (showContent) greeting.greet() else state.greeting,
            )
        }
    }
}
