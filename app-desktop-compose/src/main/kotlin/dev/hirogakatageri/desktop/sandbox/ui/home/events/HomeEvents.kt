package dev.hirogakatageri.desktop.sandbox.ui.home.events

sealed interface HomeEvents {

    data class IncrementCount(val currentCount: Int): HomeEvents

    object ResetCount: HomeEvents

}
