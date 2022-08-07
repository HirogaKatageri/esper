package dev.hirogakatageri.esper.demo

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.hirogakatageri.esper.SimpleEventStateProcessor
import dev.hirogakatageri.esper.demo.events.HomeEvents
import dev.hirogakatageri.esper.demo.state.CountState
import dev.hirogakatageri.esper.demo.usecase.IncrementCountUseCase
import dev.hirogakatageri.esper.demo.usecase.ResetCountUseCase
import kotlinx.coroutines.Dispatchers

class MainViewModel(private val state: SavedStateHandle): ViewModel() {

    val counterEsp = SimpleEventStateProcessor<HomeEvents, CountState>(
        viewModelScope,
        Dispatchers.IO,
        state.get<CountState>("counter") ?: CountState(0)
    ) { event ->
        when (event) {
            is HomeEvents.IncrementCount -> {
                val newState = IncrementCountUseCase().invoke(event)
                state["counter"] = newState
                newState
            }

            HomeEvents.ResetCount -> ResetCountUseCase().invoke()
        }
    }

}