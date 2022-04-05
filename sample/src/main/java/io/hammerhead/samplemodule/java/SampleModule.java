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

package io.hammerhead.samplemodule.java;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

import io.hammerhead.samplemodule.java.appval.AppValDataType;
import io.hammerhead.samplemodule.java.customspeed.CustomSpeedDataType;
import io.hammerhead.samplemodule.java.powerhr.PowerHeartRateDataType;
import io.hammerhead.samplemodule.kotlin.RideCard;
import io.hammerhead.sdk.v0.Module;
import io.hammerhead.sdk.v0.ModuleFactoryI;
import io.hammerhead.sdk.v0.SdkContext;
import io.hammerhead.sdk.v0.card.PostRideCard;
import io.hammerhead.sdk.v0.card.RideDetailsI;
import io.hammerhead.sdk.v0.datatype.SdkDataType;
import timber.log.Timber;

public class SampleModule extends Module {
    public static ModuleFactoryI factory = new ModuleFactoryI() {
        @Override
        public Module buildModule(@NotNull SdkContext context) {
            return new SampleModule(context);
        }
    };

    public SampleModule(SdkContext context) {
        super(context);
    }

    @NotNull
    @Override
    public String getName() {
        return "sample";
    }

    @NotNull
    @Override
    public String getVersion() {
        return "1.0";
    }

    @Override
    public boolean onStart() {
        Timber.i("SampleModule received ride start event");
        return false;
    }

    @NotNull
    @Override
    public List<SdkDataType> provideDataTypes() {
        return Arrays.asList(
                new AppValDataType(getContext()),
                new CustomSpeedDataType(getContext()),
                new PowerHeartRateDataType(getContext())
        );
    }

    @Override
    public PostRideCard postRideCard(@NotNull RideDetailsI details) {
        // Use the kotlin RideCard because it's not worth porting to Java.
        return new RideCard(getContext(), details);
    }
}
