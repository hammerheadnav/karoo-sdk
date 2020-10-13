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

    override fun onUpdate(view: View, value: Double) {
        view.text_speed.text = context.getString(R.string.valid)
        view.numeric_speed.apply {
            visibility = View.VISIBLE
            text = String.format("%.2f", value).reversed()
        }
    }

    override fun onInvalid(view: View) {
        view.text_speed.text = context.getString(R.string.invalid)
        view.numeric_speed.visibility = View.GONE
    }
}
