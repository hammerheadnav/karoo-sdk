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
package io.hammerhead.samplemodule.kotlin

import android.content.Intent
import io.hammerhead.samplemodule.kotlin.appval.AppValDataType
import io.hammerhead.samplemodule.kotlin.customspeed.CustomSpeedDataType
import io.hammerhead.samplemodule.kotlin.doubleridetime.DoubleRideTimeDataType
import io.hammerhead.sdk.v0.Module
import io.hammerhead.sdk.v0.ModuleFactoryI
import io.hammerhead.sdk.v0.SdkContext
import io.hammerhead.sdk.v0.card.PostRideCard
import io.hammerhead.sdk.v0.card.RideDetails
import io.hammerhead.sdk.v0.datatype.SdkDataType
import timber.log.Timber

class SampleModule(context: SdkContext) : Module(context) {
    override val name: String = "sample"
    override val version: String = "1.0"
    override val settingsIntent: Intent? by lazy {
        Intent().setClassName("io.hammerhead.sample", "io.hammerhead.sample.DetailActivity")
    }

    override fun onStart(): Boolean {
        Timber.i("SampleModule received ride start event")
        return false
    }

    override fun provideDataTypes(): List<SdkDataType> {
        return listOf(
            CustomSpeedDataType(context),
            DoubleRideTimeDataType(context),
            AppValDataType(context)
        )
    }

    override fun postRideCard(details: RideDetails): PostRideCard? {
        return RideCard(context, details)
    }

    companion object {
        @JvmField
        val factory = object : ModuleFactoryI {
            override fun buildModule(context: SdkContext): Module {
                return SampleModule(context)
            }
        }
    }
}