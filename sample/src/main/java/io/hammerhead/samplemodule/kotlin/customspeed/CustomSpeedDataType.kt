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

package io.hammerhead.samplemodule.kotlin.customspeed

import io.hammerhead.sdk.v0.SdkContext
import io.hammerhead.sdk.v0.datatype.Dependency
import io.hammerhead.sdk.v0.datatype.SdkDataType
import io.hammerhead.sdk.v0.datatype.formatter.BuiltInFormatter
import io.hammerhead.sdk.v0.datatype.formatter.SdkFormatter
import io.hammerhead.sdk.v0.datatype.transformer.BuiltInTransformer
import io.hammerhead.sdk.v0.datatype.transformer.SdkTransformer
import io.hammerhead.sdk.v0.datatype.view.SdkView

class CustomSpeedDataType(context: SdkContext) : SdkDataType(context) {
    override val typeId: String = "custom-speed"
    override val displayName: String = "Custom Speed"
    override val description: String = "Shows speed in custom view"
    override val dependencies = listOf(Dependency.SPEED)
    override val sampleValue: Double = 13.0

    override fun newView(): SdkView = CustomSpeedSdkView(context)
    override fun newFormatter(): SdkFormatter = BuiltInFormatter.Numeric(1)
    override fun newTransformer(): SdkTransformer = BuiltInTransformer.Identity(context)
}
