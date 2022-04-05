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

package io.hammerhead.sdk.v0

/**
 * Interface for factory to build a custom Karoo SDK module.
 *
 * @sample [io.hammerhead.samplemodule.kotlin.SampleModule.factory]
 */
interface ModuleFactoryI {
    /**
     * Builds the custom Karoo SDK module for use in the Karoo System.
     *
     * @param context provided by Karoo System when calling the entry point from manifest
     * @return The extended Karoo SDK [Module]
     */
    fun buildModule(context: SdkContext): Module
}
