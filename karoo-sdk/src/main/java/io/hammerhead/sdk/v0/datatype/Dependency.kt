/**
 * Copyright (c) 2021 Hammerhead Navigation Inc.
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

package io.hammerhead.sdk.v0.datatype

import io.hammerhead.sdk.v0.datatype.transformer.SdkTransformer

/**
 * Enumeration of possible dependencies for [SdkDataType].
 *
 * Provided as a list in [SdkDataType.dependencies]
 */
enum class Dependency {
    /**
     * Dependency on highest-priority sensor providing speed in m/s.
     */
    SPEED,

    /**
     * Dependency on highest-priority sensor providing power in W.
     */
    POWER,

    /**
     * Dependency on highest-priority sensor providing cadence in rpm.
     */
    CADENCE,

    /**
     * Dependency on highest-priority sensor providing heart rate in bpm.
     */
    HEART_RATE,

    /**
     * Dependency on active riding time of recording in ms, stops when paused.
     */
    RIDE_TIME,

    /**
     * Dependency on elapsed time recording in ms, continues while paused.
     */
    ELAPSED_TIME,

    /**
     * Special dependency with no values but used to ensure
     * [SdkTransformer.onDependencyChange] is called at a rate of 1Hz
     */
    INTERVAL
}
