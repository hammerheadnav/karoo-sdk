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
package io.hammerhead.sdk.v0

import android.content.Context
import android.content.ContextWrapper
import android.content.res.Resources

/**
 * Context wrapper specifically for use within external code (Karoo SDK Module)
 * while running within the Karoo System. This allows use of the originating packages
 * resources within the Karoo System app context.
 */
class SdkContext internal constructor(
    /**
     * @suppress
     */
    val sourcePackageName: String,
    baseContext: Context,
    private val moduleResources: Resources
) : ContextWrapper(baseContext) {
    private val moduleTheme by lazy { moduleResources.newTheme() }
    private var moduleClassLoader: ClassLoader? = null

    /**
     * @suppress
     */
    internal constructor(
        sourcePackageName: String,
        baseContext: Context,
        moduleResources: Resources,
        moduleClassLoader: ClassLoader
    ) : this(sourcePackageName, baseContext, moduleResources) {
        this.moduleClassLoader = moduleClassLoader
    }

    /**
     * @suppress
     */
    override fun getTheme(): Resources.Theme = moduleTheme

    /**
     * @suppress
     */
    override fun getResources(): Resources = moduleResources

    /**
     * @suppress
     */
    override fun getClassLoader(): ClassLoader {
        return moduleClassLoader ?: super.getClassLoader()
    }

    /**
     * Access the key-value storage associated with this context.
     * Can be used to persist values across boot, between the module
     * when run within different Karoo apps, or between SDK module and full app instance
     * when used with [buildSdkContext]
     */
    val keyValueStore by lazy {
        KeyValueStore(sourcePackageName, baseContext)
    }

    /**
     * Boolean if running on a device which supports the Karoo SDK.
     *
     * Can be used to enable Karoo SDK specific functionality.
     */
    val supportsKarooSdk by lazy {
        baseContext.packageManager.getLaunchIntentForPackage("io.hammerhead.rideapp") != null
    }

    companion object {
        /**
         * Builder for [SdkContext] context to be used within a [io.hammerhead.sdk.v0.Module].
         * Called by the Karoo system and passed to module on [io.hammerhead.sdk.v0.Module] construction.
         */
        @JvmStatic
        fun buildModuleContext(
            sourcePackageName: String,
            baseContext: Context,
            moduleResources: Resources,
            classLoader: ClassLoader
        ): SdkContext {
            return SdkContext(
                sourcePackageName,
                baseContext,
                moduleResources,
                classLoader
            )
        }

        /**
         * Builder for [SdkContext] when a Karoo SDK Context is required within
         * normal application, not within a [io.hammerhead.sdk.v0.Module].
         */
        @JvmStatic
        fun buildSdkContext(appContext: Context): SdkContext {
            return SdkContext(
                appContext.packageName,
                appContext,
                appContext.resources
            )
        }

        /**
         * Broadcast by Karoo System when online initialization should be performed.
         *
         * `io.hammerhead.sdk.INITIALIZE`
         *
         * Should be added to manifest with a [android.content.BroadcastReceiver] to
         * handle app setup.
         *
         * @sample io.hammerhead.samplemodule.kotlin.SdkInitReceiver
         */
        const val INTENT_INITIALIZE = "io.hammerhead.sdk.INITIALIZE"
    }
}
