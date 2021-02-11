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

import com.garmin.fit.DeveloperFieldDescription
import com.garmin.fit.Mesg
import com.garmin.fit.MesgDefinition

/**
 * Listener interface which is used in [PostRideCard] to access
 * FIT file data as it is decoded.
 *
 * Use with [RideDetailsI.registerFitFileListener] on [PostRideCard] construction.
 *
 */
interface FitFileListener {
    /**
     * Called when decoding is started.
     * Calls to [onMesg] will start.
     */
    fun onStartDecoding()

    /**
     * Called when decoding has finished processing all records.
     * No more calls to [onMesg] will be made.
     */
    fun onEndDecoding()

    /**
     * Called when a [Mesg] is decoded from the FIT file.
     *
     * @see [com.garmin.fit.MesgListener]
     */
    fun onMesg(mesg: Mesg)

    /**
     * Called when a [MesgDefinition] is decoded from the FIT file.
     *
     * @see [com.garmin.fit.MesgDefinitionListener]
     */
    fun onMesgDefinition(mesgDef: MesgDefinition) {}

    /**
     * Called when a [DeveloperFieldDescription] is decoded from the FIT file.
     *
     * @see [com.garmin.fit.DeveloperFieldDescriptionListener]
     */
    fun onDescription(desc: DeveloperFieldDescription) {}
}
