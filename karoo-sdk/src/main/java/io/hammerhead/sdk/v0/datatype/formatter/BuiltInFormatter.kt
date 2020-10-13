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
package io.hammerhead.sdk.v0.datatype.formatter

import io.hammerhead.sdk.v0.datatype.view.SdkView

sealed class BuiltInFormatter : SdkFormatter() {
    /**
     * Standard numeric formatting based on precision.
     *
     * @param precision number of digits to show after decimal point
     */
    class Numeric(val precision: Int) : BuiltInFormatter()

    /**
     * Placeholder for use with [SdkView]
     */
    class None : BuiltInFormatter()

    /**
     * @suppress
     */
    override fun formatValue(value: Double): String = ""
}
