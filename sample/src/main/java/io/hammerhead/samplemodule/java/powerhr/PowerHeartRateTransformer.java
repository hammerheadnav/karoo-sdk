/*
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
package io.hammerhead.samplemodule.java.powerhr;

import org.jetbrains.annotations.NotNull;

import java.util.Map;

import io.hammerhead.sdk.v0.SdkContext;
import io.hammerhead.sdk.v0.datatype.Dependency;
import io.hammerhead.sdk.v0.datatype.transformer.SdkTransformer;

class PowerHeartRateTransformer extends SdkTransformer {
    public PowerHeartRateTransformer(@NotNull SdkContext context) {
        super(context);
    }

    @Override
    public double onDependencyChange(long timeStamp, @NotNull Map<Dependency, Double> dependencies) {
        Double heartRate = dependencies.get(Dependency.HEART_RATE);
        if (heartRate == null || heartRate == MISSING_VALUE) {
            return MISSING_VALUE;
        }
        Double power = dependencies.get(Dependency.POWER);
        if (power == null || power == MISSING_VALUE) {
            return MISSING_VALUE;
        }
        return power / heartRate;
    }
}
