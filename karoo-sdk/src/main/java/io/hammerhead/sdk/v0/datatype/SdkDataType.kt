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
package io.hammerhead.sdk.v0.datatype

import android.content.Context
import android.graphics.drawable.Drawable
import io.hammerhead.sdk.v0.SdkContext
import io.hammerhead.sdk.v0.datatype.formatter.BuiltInFormatter
import io.hammerhead.sdk.v0.datatype.formatter.SdkFormatter
import io.hammerhead.sdk.v0.datatype.transformer.BuiltInTransformer
import io.hammerhead.sdk.v0.datatype.transformer.SdkTransformer
import io.hammerhead.sdk.v0.datatype.view.BuiltInView
import io.hammerhead.sdk.v0.datatype.view.SdkView

/**
 * Definition of an extended data field to add to the Karoo System.
 *
 * @sample [io.hammerhead.samplemodule.kotlin.customspeed.CustomSpeedDataType]
 * @sample [io.hammerhead.samplemodule.kotlin.doubleridetime.DoubleRideTimeDataType]
 * @sample [io.hammerhead.samplemodule.kotlin.appval.AppValDataType]
 */
abstract class SdkDataType(
    /**
     * SDK context for use within transformers, views, or formatters.
     */
    protected val context: SdkContext
) {
    /**
     * Unique type identifier for this data field.
     *
     * @sample [io.hammerhead.samplemodule.kotlin.customspeed.CustomSpeedDataType.typeId]
     * @sample [io.hammerhead.samplemodule.kotlin.doubleridetime.DoubleRideTimeDataType.typeId]
     * @sample [io.hammerhead.samplemodule.kotlin.appval.AppValDataType.typeId]
     */
    abstract val typeId: String

    /**
     * Name used as a title for this data field.
     *
     * @sample [io.hammerhead.samplemodule.kotlin.customspeed.CustomSpeedDataType.displayName]
     * @sample [io.hammerhead.samplemodule.kotlin.doubleridetime.DoubleRideTimeDataType.displayName]
     * @sample [io.hammerhead.samplemodule.kotlin.appval.AppValDataType.displayName]
     */
    abstract val displayName: String

    /**
     * Long description of this field.
     *
     * @sample [io.hammerhead.samplemodule.kotlin.customspeed.CustomSpeedDataType.description]
     * @sample [io.hammerhead.samplemodule.kotlin.doubleridetime.DoubleRideTimeDataType.description]
     * @sample [io.hammerhead.samplemodule.kotlin.appval.AppValDataType.description]
     */
    abstract val description: String

    /**
     * Optional definition of icons used to prefix label in-ride for this field.
     *
     * Default: null - resulting in standard icon(s) based on dependencies.
     *
     * @see [dependencies]
     * @sample [io.hammerhead.samplemodule.kotlin.doubleridetime.DoubleRideTimeDataType.displayIcons]
     */
    open fun displayIcons(context: Context): List<Drawable>? = null

    /**
     * Optional - determines whether this data type should be included
     * in ride summary. This should only be set to true for data types
     * whose last value should be shown in the ride-review screen.
     *
     * Default: false - not shown in ride-review
     */
    open val summaryField: Boolean = false

    /**
     * Optional definition of zero or more dependent data types.
     *
     * Default: [Dependency.INTERVAL] 1s intervals
     *
     * @see [Dependency]
     */
    open val dependencies: List<Dependency> = listOf(Dependency.INTERVAL)

    /**
     * Option value to show when showing this field in demo mode.
     *
     * @sample [io.hammerhead.samplemodule.kotlin.doubleridetime.DoubleRideTimeDataType.sampleValue]
     * @sample [io.hammerhead.samplemodule.kotlin.appval.AppValDataType.sampleValue]
     */
    open val sampleValue: Double = 84.0

    /**
     * Method to define how the data field is displayed.
     *
     * @see [SdkView]
     * @see [BuiltInView]
     *
     * @sample [io.hammerhead.samplemodule.kotlin.customspeed.CustomSpeedDataType.newView]
     */
    abstract fun newView(): SdkView

    /**
     * Method to define how the data field is formatted.
     *
     * Note: not used in case of custom [SdkView]. Should
     * be defines for use with [BuiltInView.Numeric].
     *
     * @see [SdkFormatter]
     * @see [BuiltInFormatter]
     *
     * @sample [io.hammerhead.samplemodule.kotlin.doubleridetime.DoubleRideTimeDataType.newFormatter]
     * @sample [io.hammerhead.samplemodule.kotlin.appval.AppValDataType.newFormatter]
     */
    abstract fun newFormatter(): SdkFormatter

    /**
     * Method to define how the data field output is
     * based on dependencies.
     *
     * @see [SdkTransformer]
     * @see [BuiltInTransformer]
     *
     * @sample [io.hammerhead.samplemodule.kotlin.doubleridetime.DoubleRideTimeDataType.newTransformer]
     * @sample [io.hammerhead.samplemodule.kotlin.appval.AppValDataType.newTransformer]
     */
    abstract fun newTransformer(): SdkTransformer
}