package dev.hirogakatageri.desktop.sandbox.esp

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

abstract class EventStateProcessor<in E, out S>(
    scope: CoroutineScope,
    defaultState: S,
): EventState<E, S> {

    private val _state: MutableStateFlow<S> = MutableStateFlow(defaultState)
    override val state: StateFlow<S> get() = _state

    private val _event: MutableStateFlow<E?> = MutableStateFlow(null)

    private val _loadingState: MutableStateFlow<S?> = MutableStateFlow(null)

    /**
     * This can be subscribed to in order to show a LOADING state based on event data.
     * The value becomes null once processEvent() is finished.
     * */
    override val loadingState: StateFlow<S?> get() = _loadingState

    init {
        scope.launch(Dispatchers.IO) {
            _event.collect { event ->
                if (event != null) {
                    _loadingState.value = createLoadingState(event)
                    _state.value = createState(event)
                }
                _loadingState.value = null
            }
        }
    }

    override fun postEvent(event: E) {
        _event.value = event
    }

    override fun postEvent(event: () -> E) {
        _event.value = event()
    }

    open suspend fun createLoadingState(event: E): S? = null

    abstract suspend fun createState(event: E): S

}