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
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.hammerhead.sample.R
import io.hammerhead.sdk.v0.SdkContext
import io.hammerhead.sdk.v0.card.PostRideCard
import io.hammerhead.sdk.v0.card.RideDetails
import kotlinx.android.synthetic.main.ride_card_view.view.*

class RideCard(context: SdkContext, rideDetails: RideDetails) : PostRideCard(context, rideDetails) {
    override fun createView(layoutInflater: LayoutInflater, parent: ViewGroup): View {
        val view = layoutInflater.inflate(R.layout.ride_card_view, parent, false)
        view.activityName.text = rideDetails.name
        view.setOnClickListener {
            val detail = Intent().setClassName("io.hammerhead.sample", "io.hammerhead.sample.DetailActivity")
            context.startActivity(detail)
        }
        return view
    }
}
