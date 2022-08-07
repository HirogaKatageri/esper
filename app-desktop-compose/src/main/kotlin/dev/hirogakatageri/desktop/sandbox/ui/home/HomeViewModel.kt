package dev.hirogakatageri.desktop.sandbox.ui.home

import dev.hirogakatageri.desktop.sandbox.ui.home.events.HomeEvents
import dev.hirogakatageri.desktop.sandbox.ui.home.state.CountState
import dev.hirogakatageri.desktop.sandbox.ui.home.usecase.IncrementCountUseCase
import dev.hirogakatageri.desktop.sandbox.ui.home.usecase.ResetCountUseCase
import dev.hirogakatageri.esper.SimpleEventStateProcessor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

class HomeViewModel: CoroutineScope {

    override val coroutineContext: CoroutineContext = Dispatchers.IO

    val counterEsp = SimpleEventStateProcessor<HomeEvents, CountState>(
        this,
        dispatcher = Dispatchers.IO,
        defaultState = CountState(0)
    ) { event ->
        when (event) {
            is HomeEvents.IncrementCount -> IncrementCountUseCase().invoke(event)
            HomeEvents.ResetCount -> ResetCountUseCase().invoke()
        }
    }
}


