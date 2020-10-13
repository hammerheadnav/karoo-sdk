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
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import io.hammerhead.sdk.v0.SdkContext
import org.junit.Test
import kotlin.test.assertEquals
import io.hammerhead.samplemodule.java.SampleModule as JavaSampleModule
import io.hammerhead.samplemodule.kotlin.SampleModule as KotlinSampleModule

class ModuleFactoryTest {
    private val mockContentResolver = mock<ContentResolver>()
    private val mockContext = mock<Context>().apply {
        whenever(contentResolver).thenReturn(mockContentResolver)
    }
    private val testSdkContext = SdkContext.buildModuleContext("io.test", mockContext, mock())

    @Test
    fun testKotlinProvider() {
        val module = KotlinSampleModule.factory.buildModule(testSdkContext)
        assertEquals("sample", module.name)
        assertEquals("1.0", module.version)
        assertEquals(3, module.dataTypes.size)
    }

    @Test
    fun testJavaProvider() {
        val module = JavaSampleModule.factory.buildModule(testSdkContext)
        assertEquals("sample", module.name)
        assertEquals("1.0", module.version)
        assertEquals(3, module.dataTypes.size)
    }
}
