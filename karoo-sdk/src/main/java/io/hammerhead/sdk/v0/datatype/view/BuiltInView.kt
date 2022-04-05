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

sealed class BuiltInView(context: Context) : SdkView(context) {
    /**
     * Built-in view for displaying a numeric data field.
     */
    class Numeric(context: Context) : BuiltInView(context)

    /**
     * @suppress
     */
    override fun createView(layoutInflater: LayoutInflater, parent: ViewGroup): View = View(context)

    /**
     * @suppress
     */
    override fun onUpdate(view: View, value: Double, formattedValue: String?) {}

    /**
     * @suppress
     */
    override fun onInvalid(view: View) {}
}
