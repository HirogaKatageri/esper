package dev.hirogakatageri.desktop.sandbox.ui.home.usecase

import dev.hirogakatageri.desktop.sandbox.ui.home.state.CountState

class ResetCountUseCase {

    operator fun invoke() = CountState(0)
}