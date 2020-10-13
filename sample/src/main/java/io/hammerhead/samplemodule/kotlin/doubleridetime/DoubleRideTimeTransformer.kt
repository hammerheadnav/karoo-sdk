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

import io.hammerhead.sdk.v0.SdkContext
import io.hammerhead.sdk.v0.datatype.Dependency
import io.hammerhead.sdk.v0.datatype.transformer.SdkTransformer
import timber.log.Timber

class DoubleRideTimeTransformer(context: SdkContext) : SdkTransformer(context) {

    override fun onPause(): Boolean {
        Timber.i("DoubleRideTimeTransformer got pause event, resend dep")
        super.onPause()
        return true
    }

    override fun onDependencyChange(
        timeStamp: Long,
        dependencies: Map<Dependency, Double>
    ): Double {
        return dependencies[Dependency.RIDE_TIME]?.let {
            if (it != MISSING_VALUE) {
                (it * 2.0) / 1000.0
            } else null
        } ?: MISSING_VALUE
    }
}
