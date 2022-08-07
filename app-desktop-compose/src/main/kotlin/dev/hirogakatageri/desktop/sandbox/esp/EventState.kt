package dev.hirogakatageri.desktop.sandbox.esp

import kotlinx.coroutines.flow.StateFlow

interface EventState<in E, out S> {

    val state: StateFlow<S>

    val loadingState: StateFlow<S?>

    fun postEvent(event: E)

    fun postEvent(event: () -> E)

}