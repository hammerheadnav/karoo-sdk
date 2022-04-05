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

package io.hammerhead.sdk.v0.card

/**
 * Access to details from a recorded ride.
 *
 * Can be used to show custom post-ride card with [PostRideCard].
 */
interface RideDetailsI {
    /**
     * Hammerhead Ride ID
     */
    val id: String

    /**
     * Ride name
     */
    val name: String

    /**
     * Ride duration in ms.
     */
    val duration: Long

    /**
     * Ride distance in meters
     */
    val distance: Double

    /**
     * Map of summary fields (SdkDataType where summaryField is true)
     * to last double value produced from ride.
     *
     * Key will be [io.hammerhead.sdk.v0.datatype.SdkDataType.typeId]
     */
    val summaryFields: Map<String, Double>

    /**
     * External IDs that have been successfully synced. Keys will be
     * one of: [STRAVA], [TRAINING_PEAKS], [KOMOOT], [RIDE_WITH_GPS], [XERT].
     */
    val externalIds: Map<String, String>

    /**
     * Called to register a listener for access to FIT file records
     * for this ride as they are decoded.
     */
    fun registerFitFileListener(listener: FitFileListener)

    companion object {
        /**
         * Value representing string key for Strava in `externalIds`
         */
        @JvmField
        val STRAVA = "strava"

        /**
         * Value representing string key for TrainingPeaks in `externalIds`
         */
        @JvmField
        val TRAINING_PEAKS = "training_peaks"

        /**
         * Value representing string key for Komoot in `externalIds`
         */
        @JvmField
        val KOMOOT = "komoot"

        /**
         * Value representing string key for RideWithGPS in `externalIds`
         */
        @JvmField
        val RIDE_WITH_GPS = "ride_with_gps"

        /**
         * Value representing string key for Xert in `externalIds`
         */
        @JvmField
        val XERT = "xert"
    }
}
