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
package io.hammerhead.samplemodule.kotlin.customspeed

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.hammerhead.sample.R
import io.hammerhead.sdk.v0.datatype.view.SdkView
import kotlinx.android.synthetic.main.custom_speed_view.view.*

class CustomSpeedSdkView(context: Context) : SdkView(context) {
    override fun createView(layoutInflater: LayoutInflater, parent: ViewGroup): View {
        return layoutInflater.inflate(R.layout.custom_speed_view, parent, false)
    }

    override fun onUpdate(view: View, value: Double, formattedValue: String?) {
        view.status_text.visibility = View.GONE
        formattedValue?.let {
            view.speed_text.apply {
                visibility = View.VISIBLE
                text = it
            }
        }
        view.speed_gauge.apply {
            visibility = View.VISIBLE
            val progressPct = (value.coerceAtMost(MAX_SPEED) / MAX_SPEED) * 100f
            progress = progressPct.toFloat()
        }
    }

    override fun onInvalid(view: View) {
        view.status_text.apply {
            text = context.getString(R.string.disconnected)
            visibility = View.VISIBLE
        }
        view.speed_text.visibility = View.GONE
        view.speed_gauge.visibility = View.GONE
    }

    companion object {
        private const val MAX_SPEED = 17.0 // mps
    }
}
