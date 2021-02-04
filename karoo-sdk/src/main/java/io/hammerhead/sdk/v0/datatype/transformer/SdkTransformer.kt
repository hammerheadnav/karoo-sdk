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
package io.hammerhead.sdk.v0.datatype.transformer

import io.hammerhead.sdk.v0.RideLifecycleListener
import io.hammerhead.sdk.v0.RideState
import io.hammerhead.sdk.v0.SdkContext
import io.hammerhead.sdk.v0.datatype.Dependency

/**
 * Abstract class to extend the way data field is formatted.
 *
 * @see [BuiltInTransformer.Identity]
 * @sample [io.hammerhead.samplemodule.kotlin.appval.AppValTransformer]
 * @sample [io.hammerhead.samplemodule.kotlin.powerhr.PowerHeartRateTransformer]
 */
abstract class SdkTransformer(
    /**
     * @suppress
     */
    protected val context: SdkContext
) : RideLifecycleListener {
    /**
     * Current ride state
     */
    protected var rideState: RideState = RideState.IDLE

    /**
     * @suppress
     */
    override fun onStart(): Boolean {
        rideState = RideState.RECORDING
        return super.onStart()
    }

    /**
     * @suppress
     */
    override fun onPause(): Boolean {
        rideState = RideState.PAUSED
        return super.onPause()
    }

    /**
     * @suppress
     */
    override fun onResume(): Boolean {
        rideState = RideState.RECORDING
        return super.onResume()
    }

    /**
     * @suppress
     */
    override fun onEnd(): Boolean {
        rideState = RideState.IDLE
        return super.onEnd()
    }

    /**
     * Called when a dependency changes and a new output for this field should be calculated
     * or with the last value after a lifecycle change.
     */
    abstract fun onDependencyChange(
        timeStamp: Long,
        dependencies: Map<Dependency, Double>
    ): Double

    companion object {
        /**
         * Constant value representing that value is unknown or unavailable
         */
        @JvmField
        val MISSING_VALUE = Double.MAX_VALUE
    }
}
