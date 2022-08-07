package dev.hirogakatageri.desktop.sandbox.ui.home.usecase

import dev.hirogakatageri.desktop.sandbox.ui.home.events.HomeEvents
import dev.hirogakatageri.desktop.sandbox.ui.home.state.CountState

class IncrementCountUseCase {

    operator fun invoke(event: HomeEvents.IncrementCount) = CountState(event.currentCount + 1)
}

