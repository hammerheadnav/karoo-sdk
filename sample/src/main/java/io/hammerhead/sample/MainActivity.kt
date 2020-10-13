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
package io.hammerhead.sample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import io.hammerhead.sdk.v0.SdkContext
import kotlinx.android.synthetic.main.activity_main.*
import java.util.UUID

class MainActivity : AppCompatActivity() {
    private val kvStore by lazy {
        SdkContext.buildSdkContext(this).keyValueStore
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        kvStore.getToken()?.let {
            tokenText.text = "Token: $it"
        } ?: run {
            if (!kvStore.putToken(UUID.randomUUID().toString())) {
                Toast.makeText(this, "Problem storing token", Toast.LENGTH_SHORT).show()
            }
        }

        kvStore.getString(APP_VAL)?.let {
            editText.setText(it)
        }
        saveButton.setOnClickListener {
            val newValue = editText.text.toString()
            if (kvStore.putString(APP_VAL, newValue)) {
                editText.setText(newValue)
            } else {
                Toast.makeText(this, "Problem setting app value", Toast.LENGTH_SHORT).show()
                kvStore.getString(APP_VAL)?.let {
                    editText.setText(it)
                }
            }
        }
    }
}
