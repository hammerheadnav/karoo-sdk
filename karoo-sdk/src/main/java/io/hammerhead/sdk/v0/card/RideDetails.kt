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

/**
 * Details from a recorded ride.
 *
 * Can be used to show custom post-ride card with [PostRideCard].
 */
data class RideDetails(
    /**
     * Hammerhead Ride ID
     */
    val id: String,
    /**
     * Ride name
     */
    val name: String,
    /**
     * Ride duration in ms.
     */
    val duration: Long,
    /**
     * Distance in meters
     */
    val distance: Double,
    /**
     * Strava ID
     */
    val stravaId: String?,
    /**
     * Training Peaks ID
     */
    val trainingPeaksId: String?,
    /**
     * Komoot ID
     */
    val komootId: String?,
    /**
     * RideWithGPS ID
     */
    val rideWithGpsId: String?
)
