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

package io.hammerhead.samplemodule.kotlin

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import io.hammerhead.sample.APP_VAL
import io.hammerhead.sdk.v0.SdkContext
import timber.log.Timber

class SdkInitReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        Timber.d("SdkInitReceiver: Karoo is ONLINE")
        val sdkContext = SdkContext.buildSdkContext(context)
        if (sdkContext.keyValueStore.getDouble(APP_VAL) == null) {
            Timber.d("Setting initial app val")
            sdkContext.keyValueStore.putDouble(APP_VAL, 111.11)
        }
    }
}
