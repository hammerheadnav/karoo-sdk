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

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.garmin.fit.Mesg
import com.garmin.fit.RecordMesg
import io.hammerhead.sample.R
import io.hammerhead.samplemodule.kotlin.appval.AppValDataType
import io.hammerhead.samplemodule.kotlin.appval.AppValFormatter
import io.hammerhead.sdk.v0.SdkContext
import io.hammerhead.sdk.v0.card.FitFileListener
import io.hammerhead.sdk.v0.card.PostRideCard
import io.hammerhead.sdk.v0.card.RideDetailsI
import io.hammerhead.sdk.v0.card.RideDetailsI.Companion.STRAVA
import kotlinx.android.synthetic.main.ride_card_view.view.*
import timber.log.Timber

class RideCard(context: SdkContext, rideDetails: RideDetailsI) : PostRideCard(context, rideDetails), FitFileListener {
    private val elevationPoints = mutableListOf<Double>()
    private var elevationPointsReady = false
    private var view: View? = null

    init {
        rideDetailsI.registerFitFileListener(this)
    }

    override fun createView(layoutInflater: LayoutInflater, parent: ViewGroup): View {
        val view = layoutInflater.inflate(R.layout.ride_card_view, parent, false)
        rideDetailsI.summaryFields[AppValDataType.TYPE_ID]?.let {
            view.finalAppVal.text = AppValFormatter().formatValue(it)
        }
        view.rideName.text = rideDetailsI.name
        view.setOnClickListener {
            val detail = Intent().setClassName("io.hammerhead.sample", "io.hammerhead.sample.DetailActivity")
            context.startActivity(detail)
        }
        Timber.d("Strava external ID is ${rideDetailsI.externalIds[STRAVA]}")
        if (elevationPointsReady) {
            view.elevationBackground.setPoints(elevationPoints)
        }
        this.view = view
        return view
    }

    override fun onMesg(mesg: Mesg) {
        if (mesg.num == 20) {
            val record = RecordMesg(mesg)
            if (record.hasField(RecordMesg.AltitudeFieldNum)) {
                elevationPoints.add(record.getField(RecordMesg.AltitudeFieldNum).doubleValue)
            }
        }
    }

    override fun onStartDecoding() {
        elevationPoints.clear()
        elevationPointsReady = false
    }

    override fun onEndDecoding() {
        view?.elevationBackground?.setPoints(elevationPoints)
        elevationPointsReady = true
    }
}
