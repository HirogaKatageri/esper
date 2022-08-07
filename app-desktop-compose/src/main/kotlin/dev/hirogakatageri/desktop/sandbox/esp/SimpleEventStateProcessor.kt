package dev.hirogakatageri.desktop.sandbox.esp

import kotlinx.coroutines.CoroutineScope

class SimpleEventStateProcessor<in E, out S>(
    scope: CoroutineScope,
    defaultState: S,
    private val _createLoadingState: (suspend (event: E) -> S?)? = null,
    private val _createState: suspend (event: E) -> S
): EventStateProcessor<E, S>(scope, defaultState) {

    override suspend fun createLoadingState(event: E): S? = _createLoadingState?.invoke(event)
    override suspend fun createState(event: E): S = _createState(event)
}