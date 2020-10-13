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
package io.hammerhead.samplemodule.kotlin.doubleridetime

import android.content.Context
import android.graphics.drawable.Drawable
import io.hammerhead.sample.R
import io.hammerhead.sdk.v0.SdkContext
import io.hammerhead.sdk.v0.datatype.Dependency
import io.hammerhead.sdk.v0.datatype.SdkDataType
import io.hammerhead.sdk.v0.datatype.formatter.BuiltInFormatter
import io.hammerhead.sdk.v0.datatype.formatter.SdkFormatter
import io.hammerhead.sdk.v0.datatype.transformer.SdkTransformer
import io.hammerhead.sdk.v0.datatype.view.BuiltInView
import io.hammerhead.sdk.v0.datatype.view.SdkView

class DoubleRideTimeDataType(context: SdkContext) : SdkDataType(context) {
    override val typeId: String = "double-ride-time"
    override val displayName: String = "RideTimeX2"
    override val description: String = "Takes the ride time and doubles it"
    override fun displayIcons(context: Context): List<Drawable>? {
        return context.getDrawable(R.drawable.ic_double_ride_time)?.let { listOf(it) }
    }

    override val summaryField: Boolean = true
    override val dependencies = listOf(Dependency.RIDE_TIME)
    override val sampleValue: Double = 11.0

    override fun newView(): SdkView = BuiltInView.Numeric(context)
    override fun newFormatter(): SdkFormatter = BuiltInFormatter.Numeric(0)
    override fun newTransformer(): SdkTransformer = DoubleRideTimeTransformer(context)
}
