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
package io.hammerhead.sdk.v0.card

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.hammerhead.sdk.v0.SdkContext

/**
 * Definition of a post-ride card view.
 *
 * @sample [io.hammerhead.samplemodule.kotlin.RideCard]
 */
abstract class PostRideCard(
    /**
     * SDK context
     */
    protected val context: SdkContext,
    /**
     * Details for the ride card
     */
    protected val rideDetails: RideDetails
) {
    /**
     * @suppress
     */
    fun createView(parent: ViewGroup): View {
        val layoutInflater = LayoutInflater.from(context).cloneInContext(context)
        return createView(layoutInflater, parent)
    }

    /**
     * Called to inflate the layout or manually create the view
     * required for this card to show the [rideDetails].
     *
     * @param layoutInflater to be used for calls to [LayoutInflater.inflate] to ensure
     * access to resources from module's containing APK
     * @param parent the parent layout of the view being inflated
     */
    protected abstract fun createView(layoutInflater: LayoutInflater, parent: ViewGroup): View
}
