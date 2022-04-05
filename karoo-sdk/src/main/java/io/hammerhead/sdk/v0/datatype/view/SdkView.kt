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

package io.hammerhead.sdk.v0.datatype.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.hammerhead.sdk.v0.datatype.SdkDataType
import io.hammerhead.sdk.v0.datatype.transformer.SdkTransformer
import io.hammerhead.sdk.v0.datatype.formatter.SdkFormatter

/**
 * Abstract class to extend the way data fields are displayed in ride.
 *
 * @see [BuiltInView.Numeric]
 * @sample [io.hammerhead.samplemodule.kotlin.customspeed.CustomSpeedSdkView]
 *
 * @property context associated with this custom view
 */
abstract class SdkView(protected val context: Context) {
    /**
     * @suppress
     */
    fun createView(parent: ViewGroup): View {
        val layoutInflater = LayoutInflater.from(context).cloneInContext(context)
        return createView(layoutInflater, parent)
    }

    /**
     * Called to inflate the layout or manually create the view
     * required to display the [SdkDataType].
     *
     * @param layoutInflater to be used for calls to [LayoutInflater.inflate] to ensure
     * access to resources from module's containing APK
     * @param parent the parent layout of the view being inflated
     */
    protected abstract fun createView(layoutInflater: LayoutInflater, parent: ViewGroup): View

    /**
     * Called when the view should be updated based on the new value from output of the
     * [SdkTransformer].
     *
     * Legacy implementation for [onUpdate] without `formattedValue`.
     *
     * @param view original view created from `createView`
     * @param value from out put of transformer
     */
    @Deprecated("legacy signature", ReplaceWith("onUpdate"))
    open fun onUpdate(view: View, value: Double) {
    }

    /**
     * Called when the data is unavailable or otherwise invalid.
     *
     * @param view original view created from `createView`
     */
    abstract fun onInvalid(view: View)

    /**
     * Called when the view should be updated based on the new value from output of the
     * [SdkTransformer] and [SdkFormatter]
     *
     * Preferred implementation for [onUpdate] with `formattedValue`.
     *
     * @param view original view created from `createView`
     * @param value from out put of transformer
     * @param formattedValue from out put of formatter if specified
     */
    open fun onUpdate(view: View, value: Double, formattedValue: String?) {
        // If this new signature not implemented, call legacy implementation.
        onUpdate(view, value)
    }
}
