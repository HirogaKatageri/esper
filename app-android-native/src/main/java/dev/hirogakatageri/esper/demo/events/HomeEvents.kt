package dev.hirogakatageri.esper.demo.events

sealed interface HomeEvents {

    data class IncrementCount(val currentCount: Int): HomeEvents

    object ResetCount: HomeEvents

}
