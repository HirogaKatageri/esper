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

import kotlinx.coroutines.flow.StateFlow

interface EventState<in E, out S> {

    val state: StateFlow<S>

    val loadingState: StateFlow<S?>

    fun postEvent(event: E)

    fun postEvent(event: () -> E)

}