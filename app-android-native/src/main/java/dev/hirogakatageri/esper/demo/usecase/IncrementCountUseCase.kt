package dev.hirogakatageri.esper.demo.usecase

import dev.hirogakatageri.esper.demo.events.HomeEvents
import dev.hirogakatageri.esper.demo.state.CountState

class IncrementCountUseCase {

    operator fun invoke(event: HomeEvents.IncrementCount) = CountState(event.currentCount + 1)
}

