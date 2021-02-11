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
package io.hammerhead.samplemodule.kotlin.appval

import io.hammerhead.sdk.v0.SdkContext
import io.hammerhead.sdk.v0.datatype.Dependency
import io.hammerhead.sdk.v0.datatype.SdkDataType
import io.hammerhead.sdk.v0.datatype.formatter.SdkFormatter
import io.hammerhead.sdk.v0.datatype.transformer.SdkTransformer
import io.hammerhead.sdk.v0.datatype.view.BuiltInView
import io.hammerhead.sdk.v0.datatype.view.SdkView

class AppValDataType(context: SdkContext) : SdkDataType(context) {
    override val typeId: String = TYPE_ID
    override val displayName: String = "AppVal"
    override val description: String = "Shows a value from app"
    override val dependencies = listOf(Dependency.INTERVAL)
    override val summaryField: Boolean = true
    override val sampleValue: Double = 22.0

    override fun newView(): SdkView = BuiltInView.Numeric(context)
    override fun newFormatter(): SdkFormatter = AppValFormatter()
    override fun newTransformer(): SdkTransformer = AppValTransformer(context)

    companion object {
        const val TYPE_ID = "appval"
    }
}
