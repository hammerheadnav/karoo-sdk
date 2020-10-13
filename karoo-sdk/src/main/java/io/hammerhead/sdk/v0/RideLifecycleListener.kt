/**
 * Copyright 2021 Hammerhead Navigation, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.hammerhead.sdk.v0

/**
 * Interface which is called for lifecycle events related to ride.
 */
interface RideLifecycleListener {
    /**
     * Lifecycle event hook for when ride starts recording.
     *
     * @return boolean: `true` if event affect should trigger downstream actions.
     * Default: `false`
     */
    fun onStart(): Boolean = false

    /**
     * Lifecycle event hook for when ride is paused.
     *
     * @return boolean: `true` if event affect should trigger downstream actions.
     * Default: `false`
     */
    fun onPause(): Boolean = false

    /**
     * Lifecycle event hook for when ride is resumed.
     *
     * @return boolean: `true` if event affect should trigger downstream actions.
     * Default: `false`
     */
    fun onResume(): Boolean = false

    /**
     * Lifecycle event hook for when ride lap resets.
     *
     * @return boolean: `true` if event affect should trigger downstream actions.
     * Default: `false`
     */
    fun onLap(): Boolean = false

    /**
     * Lifecycle event hook for when ride stops recording.
     *
     * @return boolean: `true` if event affect should trigger downstream actions.
     * Default: `false`
     */
    fun onEnd(): Boolean = false
}
