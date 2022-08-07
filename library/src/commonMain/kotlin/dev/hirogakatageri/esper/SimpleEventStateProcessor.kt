package dev.hirogakatageri.esper

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class SimpleEventStateProcessor<in E, out S>(
    scope: CoroutineScope,
    dispatcher: CoroutineDispatcher = Dispatchers.Default,
    defaultState: S,
    private val _createLoadingState: (suspend (event: E) -> S?)? = null,
    private val _createState: suspend (event: E) -> S,
): EventStateProcessor<E, S>(scope, dispatcher, defaultState = defaultState) {

    override suspend fun createLoadingState(event: E): S? = _createLoadingState?.invoke(event)
    override suspend fun createState(event: E): S = _createState(event)
}