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
package io.hammerhead.samplemodule

import android.content.ContentResolver
import android.content.Context
import android.database.Cursor
import com.nhaarman.mockito_kotlin.anyOrNull
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.reset
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.hammerhead.sdk.v0.Module
import io.hammerhead.sdk.v0.SdkContext
import io.hammerhead.sdk.v0.datatype.Dependency
import io.hammerhead.sdk.v0.datatype.formatter.BuiltInFormatter
import io.hammerhead.sdk.v0.datatype.transformer.BuiltInTransformer
import io.hammerhead.sdk.v0.datatype.transformer.SdkTransformer.Companion.MISSING_VALUE
import io.hammerhead.sdk.v0.datatype.view.BuiltInView
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue
import io.hammerhead.samplemodule.java.SampleModule as JavaSampleModule
import io.hammerhead.samplemodule.kotlin.SampleModule as KotlinSampleModule

@RunWith(Parameterized::class)
class SampleModuleTest(private val type: String, private val module: Module) {
    // Run the entire suite for kotlin and java modules
    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "{0}")
        fun data(): Collection<Array<Any>> {
            return listOf(
                arrayOf("java", JavaSampleModule(testSdkContext)),
                arrayOf("kotlin", KotlinSampleModule(testSdkContext))
            )
        }

        private val mockContentResolver = mock<ContentResolver>()
        private val mockContext = mock<Context>().apply {
            whenever(contentResolver).thenReturn(mockContentResolver)
        }
        private val testSdkContext = SdkContext.buildModuleContext("io.test", mockContext, mock(), ClassLoader.getSystemClassLoader())
    }

    @Before
    fun resetMocks() {
        reset(mockContentResolver)
    }

    @Test
    fun testModule() {
        assertEquals(3, module.dataTypes.size)
    }

    @Test
    fun testPowerHeartRateTransformer() {
        val transformer =
            module.dataTypes.first { it.typeId == "power-hr" }.newTransformer()
        assertFalse(transformer.onStart())
        assertFalse(transformer.onPause())
        assertFalse(transformer.onResume())
        assertFalse(transformer.onLap())
        assertFalse(transformer.onEnd())

        // Not included dependency
        val notIncludedOutput = transformer.onDependencyChange(0, mapOf())
        assertEquals(MISSING_VALUE, notIncludedOutput)

        // Power only missing value
        val powerMissingOutput = transformer.onDependencyChange(
            0, mapOf(
                Dependency.POWER to 125.0,
                Dependency.HEART_RATE to MISSING_VALUE
            )
        )
        assertEquals(MISSING_VALUE, powerMissingOutput)

        // HR only missing value
        val hrMissingOutput = transformer.onDependencyChange(
                0, mapOf(
                Dependency.POWER to MISSING_VALUE,
                Dependency.HEART_RATE to 125.0
        )
        )
        assertEquals(MISSING_VALUE, hrMissingOutput)

        // Double value
        val doubleTimeOutput = transformer.onDependencyChange(
            0, mapOf(
                Dependency.POWER to 400.0,
                Dependency.HEART_RATE to 200.0
            )
        )
        assertEquals(2.0, doubleTimeOutput)
    }

    @Test
    fun testAppValTransformer() {
        val transformer = module.dataTypes.first { it.typeId == "appval" }.newTransformer()

        // Before ride start, missing
        val missingOutput = transformer.onDependencyChange(0, mapOf())
        assertEquals(MISSING_VALUE, missingOutput)

        // After ride start
        transformer.onStart()
        val mockCursor = mock<Cursor>()
        whenever(mockCursor.moveToFirst()).thenReturn(true)
        whenever(mockCursor.getString(0)).thenReturn("55.0")
        whenever(
            mockContentResolver.query(
                anyOrNull(),
                anyOrNull(),
                anyOrNull(),
                anyOrNull(),
                anyOrNull()
            )
        ).thenReturn(mockCursor)
        val valueOutput = transformer.onDependencyChange(0, mapOf())
        verify(mockContentResolver).query(
            anyOrNull(),
            anyOrNull(),
            anyOrNull(),
            anyOrNull(),
            anyOrNull()
        )
        assertEquals(55.0, valueOutput)

        // After ride end, missing
        transformer.onEnd()
        val missingOutput2 = transformer.onDependencyChange(0, mapOf())
        assertEquals(MISSING_VALUE, missingOutput2)
    }

    @Test
    fun builtIn() {
        val appVal = module.dataTypes.first { it.typeId == "appval" }
        val customSpeed = module.dataTypes.first { it.typeId == "custom-speed" }
        val powerHr = module.dataTypes.first { it.typeId == "power-hr" }

        assertTrue(appVal.newView() is BuiltInView.Numeric)
        assertTrue(customSpeed.newFormatter() is BuiltInFormatter.Numeric)
        assertTrue(customSpeed.newTransformer() is BuiltInTransformer.Identity)
        assertTrue(powerHr.newFormatter() is BuiltInFormatter.Numeric)
        assertTrue(powerHr.newView() is BuiltInView.Numeric)
    }

    @Test
    fun testAppValFormatter() {
        val formatter =
            module.dataTypes.first { it.typeId == "appval" }.newFormatter()

        val formatted = formatter.formatValue(55.0)
        assertEquals("AV:55.0", formatted)
    }
}
