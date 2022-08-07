package dev.hirogakatageri.esper.demo.usecase

import dev.hirogakatageri.esper.demo.state.CountState

class ResetCountUseCase {

    operator fun invoke() = CountState(0)
}