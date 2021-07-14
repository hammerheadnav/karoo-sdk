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

import android.util.Log
import io.hammerhead.samplemodule.kotlin.appval.AppValDataType
import io.hammerhead.samplemodule.kotlin.customspeed.CustomSpeedDataType
import io.hammerhead.samplemodule.kotlin.powerhr.PowerHeartRateDataType
import io.hammerhead.sdk.v0.Module
import io.hammerhead.sdk.v0.ModuleFactoryI
import io.hammerhead.sdk.v0.SdkContext
import io.hammerhead.sdk.v0.card.PostRideCard
import io.hammerhead.sdk.v0.card.RideDetailsI
import io.hammerhead.sdk.v0.datatype.SdkDataType
import timber.log.Timber

class SampleModule(context: SdkContext) : Module(context) {
    override val name: String = "sample"
    override val version: String = "1.0"

    override fun onStart(): Boolean {
        Timber.i("SampleModule received ride start event")
        return false
    }

    override fun provideDataTypes(): List<SdkDataType> {
        Timber.i("provideDataTypes() called")
        return listOf(
            CustomSpeedDataType(context),
            PowerHeartRateDataType(context),
            AppValDataType(context)
        )
    }

    override fun postRideCard(details: RideDetailsI): PostRideCard? {
        Timber.i("postRideCard() called")
        return RideCard(context, details)
    }

    companion object {
        init {
            Timber.plant(object : Timber.Tree() {
                override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
                    Log.println(priority, "SampleModule", t?.message ?: message)
                }
            })
        }
        @JvmField
        val factory = object : ModuleFactoryI {
            override fun buildModule(context: SdkContext): Module {
                Timber.i("buildModule() called from ${context.packageName}")
                return SampleModule(context)
            }
        }
    }
}
