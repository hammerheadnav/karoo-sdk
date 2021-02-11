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

import android.content.Intent
import android.graphics.drawable.Drawable
import io.hammerhead.sdk.v0.card.PostRideCard
import io.hammerhead.sdk.v0.card.RideDetails
import io.hammerhead.sdk.v0.card.RideDetailsI
import io.hammerhead.sdk.v0.datatype.SdkDataType

/**
 * Karoo SDK Module
 *
 * @param context provided by the Karoo System when loading the module
 * @sample [io.hammerhead.samplemodule.kotlin.SampleModule]
 */
abstract class Module(val context: SdkContext) : RideLifecycleListener {
    /**
     * Name of originating package.
     * Cannot be overridden, set during initialization when loading module.
     */
    val packageName: String by lazy { context.sourcePackageName }

    /**
     * Icon from originating package.
     * Cannot be overridden, set during initialization when loading module.
     */
    val packageIcon: Drawable by lazy { context.packageManager.getApplicationIcon(packageName) }

    /**
     * @suppress
     */
    val dataTypes by lazy { provideDataTypes() }

    /**
     * Name uniquely identifying this module.
     *
     * @sample [io.hammerhead.samplemodule.kotlin.SampleModule.name]
     */
    abstract val name: String

    /**
     * Current version of this module.
     * Independent of Karoo SDK version.
     *
     * @sample [io.hammerhead.samplemodule.kotlin.SampleModule.version]
     */
    abstract val version: String

    /**
     * Deprecated - no longer called
     */
    @Deprecated("no longer called")
    open val settingsIntent: Intent? = null

    /**
     * Deprecated
     */
    @Deprecated("no longer called", ReplaceWith("RideDetailsI"))
    open fun postRideCard(details: RideDetails): PostRideCard? = null

    /**
     * Method for optionally creating a Post-Ride Card view
     * based on [RideDetailsI].
     *
     * Default: null - no card is created
     */
    open fun postRideCard(details: RideDetailsI): PostRideCard? = null

    /**
     * Method for constructing which SDK data types
     * this module provides. Called when first needed and stored,
     * therefor this cannot be dynamic.
     *
     * @sample [io.hammerhead.samplemodule.kotlin.SampleModule.provideDataTypes]
     */
    protected abstract fun provideDataTypes(): List<SdkDataType>

    /**
     * @suppress
     */
    override fun equals(other: Any?): Boolean {
        return other is Module && name == other.name && version == other.version
    }

    /**
     * @suppress
     */
    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + version.hashCode()
        return result
    }
}
