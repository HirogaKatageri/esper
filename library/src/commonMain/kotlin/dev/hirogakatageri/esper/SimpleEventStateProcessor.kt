/*
 *    Copyright [2022] [Gian Patrick Quintana]
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

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