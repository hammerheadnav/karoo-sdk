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
package io.hammerhead.samplemodule.java.appval;

import java.util.Map;

import io.hammerhead.sdk.v0.RideState;
import io.hammerhead.sdk.v0.SdkContext;
import io.hammerhead.sdk.v0.datatype.Dependency;
import io.hammerhead.sdk.v0.datatype.transformer.SdkTransformer;

public class AppValTransformer extends SdkTransformer {

    public AppValTransformer(SdkContext context) {
        super(context);
    }

    @Override
    public double onDependencyChange(long timeStamp, Map<Dependency, Double> dependencies) {
        if (getRideState() == RideState.RECORDING) {
            Double appVal = getContext().getKeyValueStore().getDouble("appval");
            if (appVal == null) {
                return MISSING_VALUE;
            }
            return appVal;
        } else {
            return MISSING_VALUE;
        }
    }
}
