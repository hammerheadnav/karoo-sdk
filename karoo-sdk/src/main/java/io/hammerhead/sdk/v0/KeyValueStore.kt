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

import android.content.ContentValues
import android.content.Context
import android.net.Uri

/**
 * Simple storage of key/value pairs for use by Karoo SDK modules.
 * This allows modules to store values that need to be persisted
 * across rides and reboots. Additionally, allows access between
 * full APK and Karoo SDK plugins and across plugin
 * instances running within different Karoo apps.
 */
class KeyValueStore internal constructor(packageName: String, private val context: Context) {
    private val packagePrefix by lazy { packageName.replace(".", "") }

    /**
     * Get module-specific token.
     */
    fun getToken(): String? {
        return getString(TOKEN)
    }

    /**
     * Store module-specific token.
     */
    fun putToken(token: String): Boolean {
        return putString(TOKEN, token)
    }

    /**
     * Get module-specific string value based on key.
     */
    fun getString(key: String): String? {
        val uri = Uri.parse("$CONTENT_URI/kv/$packagePrefix")
        context.contentResolver.query(
                uri,
                null,
                "$KEY=?",
                listOf(key).toTypedArray(),
                null
        )?.use { cursor ->
            if (cursor.moveToFirst()) {
                return cursor.getString(cursor.getColumnIndex(VALUE))
            }
        }
        return null
    }

    /**
     * Get module-specific numeric value based on key.
     */
    fun getDouble(key: String): Double? {
        return getString(key)?.toDoubleOrNull()
    }

    /**
     * Store module-specific string value associated with key.
     */
    fun putString(key: String, value: String?): Boolean {
        val uri = Uri.parse("$CONTENT_URI/kv/$packagePrefix")
        val values = ContentValues()
        values.put(KEY, key)
        values.put(VALUE, value)
        return context.contentResolver.insert(uri, values) != null
    }

    /**
     * Store module-specific numeric value associated with key.
     */
    fun putDouble(key: String, value: Double?): Boolean {
        return putString(key, value?.toString())
    }

    companion object {
        /**
         * @suppress
         */
        const val TOKEN = "token"

        /**
         * @suppress
         */
        const val CONTENT_URI = "content://io.hammerhead.sdk.v0.SdkContentProvider"

        /**
         * @suppress
         */
        const val KEY = "key"

        /**
         * @suppress
         */
        const val VALUE = "value"
    }
}
